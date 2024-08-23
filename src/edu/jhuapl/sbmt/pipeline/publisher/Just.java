package edu.jhuapl.sbmt.pipeline.publisher;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <OutputType>
 */
public class Just<OutputType extends Object> extends BasePipelinePublisher<OutputType>
{
	/**
	 * Prepares the publisher to emit a single output to the subscriber
	 * 
	 * @param input
	 */
	public Just(OutputType input)
	{
		this.outputs = new ArrayList<OutputType>();
		outputs.add(input);
	}

	/**
	 * Prepares the publisher to emit a list of outputs to the subscriber
	 * 
	 * @param inputs
	 */
	public Just(List<OutputType> inputs)
	{
		this.outputs = new ArrayList<OutputType>();
		outputs.addAll(inputs);
	}

	/**
	 * A static method to make a publisher that emits a single output to the subscriber
	 * 
	 * @param <OutputType>
	 * @param outputs
	 * @return
	 */
	public static <OutputType extends Object> Just<OutputType> of(OutputType outputs)
	{
		return new Just<OutputType>(outputs);
	}

	/**
	 * A static method to make a publisher that emits a list of outputs to the subscriber
	 * 
	 * @param <OutputType>
	 * @param outputs
	 * @return
	 */
	public static <OutputType extends Object> Just<OutputType> of(List<OutputType> outputs)
	{
		return new Just<OutputType>(outputs);
	}
}
