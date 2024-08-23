package edu.jhuapl.sbmt.pipeline.subscriber;

import java.util.List;

import com.beust.jcommander.internal.Lists;

public class Sink<O extends Object> extends BasePipelineSubscriber<O>
{
//	private IPipelinePublisher<O> publisher;

	public static <O extends Object> Sink<O> of(List<O> outputs)
	{
		return new Sink<O>(outputs);
	}

	public static <O extends Object> Sink<O> of(O output)
	{
		return new Sink<O>(output);
	}

	public Sink(List<O> outputs)
	{
		this.outputs = outputs;
	}

	public Sink(O output)
	{
		this.outputs = Lists.newArrayList();
		this.outputs.add(output);
	}
}
