package edu.jhuapl.sbmt.pipeline;

import java.io.IOException;

/**
 * Generic pipeline component interface
 */
public interface IPipelineComponent
{
	/**
	 * The method that causes this component to process its data. 
	 * 
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public IPipelineComponent run() throws IOException, Exception;
}
