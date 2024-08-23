package edu.jhuapl.sbmt.pipeline.subscriber;

import java.util.List;

import com.beust.jcommander.internal.Lists;

/**
 * @param <O>
 */
public class Sink<O extends Object> extends BasePipelineSubscriber<O>
{

	/**
	 * Helper method to build a Sink from a list of inputs
	 * 
	 * @param <O>
	 * @param outputs
	 * @return
	 */
	public static <O extends Object> Sink<O> of(List<O> outputs)
	{
		return new Sink<O>(outputs);
	}

	/**
	 * Helper method to build a Sink from one input
	 * 
	 * @param <O>
	 * @param output
	 * @return
	 */
	public static <O extends Object> Sink<O> of(O output)
	{
		return new Sink<O>(output);
	}

	/**
	 * Constructor that takes in a list of inputs from the publisher
	 * 
	 * @param outputs
	 */
	public Sink(List<O> outputs)
	{
		this.outputs = outputs;
	}

	/**
	 * Constructor that takes in a single input from the publisher
	 * 
	 * @param output
	 */
	public Sink(O output)
	{
		this.outputs = Lists.newArrayList();
		this.outputs.add(output);
	}
}
