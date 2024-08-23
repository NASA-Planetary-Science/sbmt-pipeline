package edu.jhuapl.sbmt.pipeline;

import java.util.List;

/**
 * Interface for a pipeline, which is a publisher, 0 or more operators, and a subscriber.
 * 
 * @param <T>
 */
public interface IPipeline<T>
{
	/**
	 * Triggers a run of the entire pipeline, which will call run on each component back up the pipeline to the publisher, which 
	 * will then call each connected <p>IPipelineComponent</p> in series. 
	 * 
	 * @throws Exception
	 */
	public void run() throws Exception;

	/**
	 * Returns the output from this pipeline (fetched from the subscriber) of type <p>List<T></p>
	 * 
	 * @return
	 */
	public List<T> getOutput();
}
