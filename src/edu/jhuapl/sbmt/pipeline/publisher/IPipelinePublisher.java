package edu.jhuapl.sbmt.pipeline.publisher;

import java.io.IOException;
import java.util.List;

import edu.jhuapl.sbmt.pipeline.IPipelineComponent;
import edu.jhuapl.sbmt.pipeline.operator.IPipelineOperator;
import edu.jhuapl.sbmt.pipeline.subscriber.IPipelineSubscriber;

/**
 * @param <OutputType>
 */
public interface IPipelinePublisher<OutputType extends Object> extends IPipelineComponent
{
	/**
	 * Publishes the output to the subscriber.
	 * 
	 * @throws IOException
	 * @throws Exception
	 */
	public void publish() throws IOException, Exception;

	public IPipelinePublisher<OutputType> subscribe(IPipelineSubscriber<OutputType> subscriber);

	/**
	 * Performs an operation to generate and prepare the outputs of this publisher for emission to the subscriber
	 * 
	 * @param <T>
	 * @param operator
	 * @return
	 */
	public <T extends Object> IPipelineOperator<OutputType, T> operate(IPipelineOperator<OutputType, T> operator);

	/**
	 * Returns a list of outputs from this publisher
	 * 
	 * @return
	 */
	public List<OutputType> getOutputs();

	/**
	 * Returns the single output from this publisher
	 * 
	 * @return
	 */
	public OutputType getOutput();
}
