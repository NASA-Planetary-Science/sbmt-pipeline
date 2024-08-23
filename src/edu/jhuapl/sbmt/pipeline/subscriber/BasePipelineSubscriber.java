package edu.jhuapl.sbmt.pipeline.subscriber;

import java.io.IOException;
import java.util.List;

import edu.jhuapl.sbmt.pipeline.publisher.IPipelinePublisher;

public abstract class BasePipelineSubscriber<O extends Object> implements IPipelineSubscriber<O>
{
	protected IPipelinePublisher<O> publisher;
	protected List<O> outputs;

	public BasePipelineSubscriber()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void receive(List<O> items) throws IOException, Exception
	{
		this.outputs.addAll(items);
	}

	@Override
	public void receive(O item) throws IOException, Exception
	{
		receive(List.of(item));
	}

	@Override
	public void setPublisher(IPipelinePublisher<O> publisher)
	{
		this.publisher = publisher;
	}
	
	@Override
	public BasePipelineSubscriber<O> run() throws IOException, Exception
	{
		publisher.run();
		return this;
	}

}
