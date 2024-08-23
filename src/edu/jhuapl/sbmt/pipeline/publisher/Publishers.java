package edu.jhuapl.sbmt.pipeline.publisher;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

/**
 * A series of static helper methods for zipping merging and gathering up different publishers so they work as a single entity
 * in the pipeline
 * 
 * @param <O>
 */
public class Publishers<O extends Object> extends BasePipelinePublisher<O>
{

	/**
	 * Simple constructor that take in a list of inputs and sets them as the output of the publisher
	 * 
	 * @param inputs
	 */
	public Publishers(List<O> inputs)
	{
		outputs = new ArrayList<O>(inputs);
	}

	/**
	 * Helper method that zips all of the elements from the incoming publishers into a single publisher
	 * 
	 * @param publishers
	 * @return
	 */
	@SafeVarargs
	public static Publishers<Object> zip(Object... publishers)
	{
		List<Object> outputs = new ArrayList<Object>();
		for (Object publisher : publishers)
		{
			outputs.add(((IPipelinePublisher<Object>)publisher).getOutputs().get(0));
		}
		return new Publishers<Object>(outputs);
	}

	/**
	 * Helper method that merges the elements of multiple publishers into 1 publisher.
	 * 
	 * @param <O>
	 * @param list
	 * @return
	 */
	@SafeVarargs
	public static <O extends Object> Publishers<O> merge(IPipelinePublisher<? extends Object>... list)
	{
		List<O> outputs = new ArrayList<O>();
		for (IPipelinePublisher<? extends Object> publisher : list)
		{
			outputs.add((O) publisher.getOutputs().get(0));
		}
		return new Publishers<O>(outputs);
	}

	/**
	 * Helper methods that merges 2 different lists into one publisher
	 * 
	 * @param <O>
	 * @param list
	 * @return
	 */
	@SafeVarargs
	public static <O extends Object> Publishers<List<O>> mergeLists(IPipelinePublisher<? extends Object>... list)
	{
		List<List<O>> outputs = new ArrayList<List<O>>();
		for (IPipelinePublisher<? extends Object> publisher : list)
		{
			outputs.add((List<O>) publisher.getOutputs());
		}
		return new Publishers<List<O>>(outputs);
	}

	/**
	 * Forms a publisher out of 2 different inputs (a pair)
	 * 
	 * @param <InputType1>
	 * @param <InputType2>
	 * @param input1
	 * @param input2
	 * @return
	 */
	public static <InputType1 extends Object, InputType2 extends Object> IPipelinePublisher<Pair<InputType1, InputType2>> formPair(IPipelinePublisher<InputType1> input1, IPipelinePublisher<InputType2> input2)
	{
			BasePipelinePublisher<Pair<InputType1, InputType2>> pub = new BasePipelinePublisher<Pair<InputType1, InputType2>>() {
			@Override
			public List<Pair<InputType1, InputType2>> getOutputs()
			{
				outputs.clear();
				for (int i=0; i < input1.getOutputs().size(); i++)
				{
					outputs.add(Pair.of(input1.getOutputs().get(i), input2.getOutputs().get(i)));
				}
				return outputs;
			}
		};
		pub.getOutputs();
		return pub;
	}

	/**
	 * Forms a publisher out of 3 different inputs (a triple)
	 * 
	 * @param <InputType1>
	 * @param <InputType2>
	 * @param <InputType3>
	 * @param input1
	 * @param input2
	 * @param input3
	 * @return
	 */
	public static <InputType1 extends Object, InputType2 extends Object, InputType3 extends Object> IPipelinePublisher<Triple<InputType1, InputType2, InputType3>> formTriple(IPipelinePublisher<InputType1> input1, IPipelinePublisher<InputType2> input2, IPipelinePublisher<InputType3> input3)
	{
		BasePipelinePublisher<Triple<InputType1, InputType2, InputType3>> pub = new BasePipelinePublisher<Triple<InputType1, InputType2, InputType3>>() {
			
			@Override
			public List<Triple<InputType1, InputType2, InputType3>> getOutputs()
			{
				outputs.clear();
				for (int i=0; i < input1.getOutputs().size(); i++)
				{
					outputs.add(Triple.of(input1.getOutputs().get(i), input2.getOutputs().get(i), input3.getOutputs().get(i)));
				}
				return outputs;
			}
		};
		pub.getOutputs();
		return pub;
	}

}
