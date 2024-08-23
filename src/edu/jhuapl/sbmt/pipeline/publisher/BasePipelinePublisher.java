package edu.jhuapl.sbmt.pipeline.publisher;

import java.io.IOException;
import java.util.List;

import com.beust.jcommander.internal.Lists;

import edu.jhuapl.sbmt.pipeline.operator.IPipelineOperator;
import edu.jhuapl.sbmt.pipeline.subscriber.IPipelineSubscriber;

/**
 * A base pipeline publisher class that can be used as a parent class for more concrete implementations.  
 * 
 * @param <O>
 */
public abstract class BasePipelinePublisher<O extends Object> implements IPipelinePublisher<O>
{
	/**
	 * The list of items that will get emitted by this publisher.
	 */
	protected List<O> outputs;

	
	/**
	 * The subscriber that will receive the outputs from this publisher
	 */
	protected IPipelineSubscriber<O> subscriber;

	public BasePipelinePublisher()
	{
		outputs = Lists.newArrayList();
	}

	@Override
	public BasePipelinePublisher<O> run() throws IOException, Exception
	{
		publish();
		return this;
	}

	@Override
	public void publish() throws IOException, Exception
	{
		subscriber.receive(outputs);
	}

	@Override
	public List<O> getOutputs()
	{
		return outputs;
	}

	@Override
	public O getOutput()
	{
		return outputs.get(0);
	}

	@Override
	public IPipelinePublisher<O> subscribe(IPipelineSubscriber<O> subscriber)
	{
		this.subscriber = subscriber;
		this.subscriber.setPublisher(this);
		return this;
	}

	@Override
	public <T extends Object> IPipelineOperator<O, T> operate(IPipelineOperator<O, T> operator)
	{
		this.subscriber = operator;
		this.subscriber.setPublisher(this);
		return operator;
	}
}
