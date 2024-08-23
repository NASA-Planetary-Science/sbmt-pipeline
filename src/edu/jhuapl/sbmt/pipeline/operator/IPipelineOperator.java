package edu.jhuapl.sbmt.pipeline.operator;

import java.io.IOException;
import java.util.List;

import edu.jhuapl.sbmt.pipeline.IPipelineComponent;
import edu.jhuapl.sbmt.pipeline.publisher.IPipelinePublisher;
import edu.jhuapl.sbmt.pipeline.subscriber.IPipelineSubscriber;

/**
 * Interface required for all pipeline operators, which take in a publisher's data, and emits data to a subscriber. 
 * 
 * @param <InputType>
 * @param <OutputType>
 */
public interface IPipelineOperator<InputType extends Object, OutputType extends Object> extends IPipelinePublisher<OutputType>, IPipelineSubscriber<InputType>, IPipelineComponent
{
	/**
	 * Takes the incoming data of type <p>InputType</p>, performs an operations on it defined by the user in the concrete 
	 * implementation, and stores the results in a container whose elements are of type <p>OutputType</p> 
	 * 
	 * @throws IOException
	 * @throws Exception
	 */
	public void processData() throws IOException, Exception;

	/**
	 * Returns the outputs of type OutputType in a <p>List</p> 
	 */
	public List<OutputType> getOutputs();

}
