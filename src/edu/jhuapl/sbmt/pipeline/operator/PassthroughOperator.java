package edu.jhuapl.sbmt.pipeline.operator;

import java.io.IOException;

/**
 * A no-op operator which simply passes data in with no changes. This can be used in a conditional where an operator may be required
 * and if not, the data can simply be passed through with this operator.
 * 
 * @param <T1>
 */
public class PassthroughOperator<T1> extends BasePipelineOperator<T1, T1>
{
	/**
	 * Default no-arg constructor
	 */
	public PassthroughOperator()
	{

	}

	@Override
	public void processData() throws IOException, Exception
	{
		for (T1 layer : inputs)
			outputs.add(layer);
	}
}
