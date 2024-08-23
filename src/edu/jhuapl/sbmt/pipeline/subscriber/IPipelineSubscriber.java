package edu.jhuapl.sbmt.pipeline.subscriber;

import java.io.IOException;
import java.util.List;

import edu.jhuapl.sbmt.pipeline.IPipelineComponent;
import edu.jhuapl.sbmt.pipeline.publisher.IPipelinePublisher;

/**
 * Basic interface for a pipeline subscriber.
 * 
 * @param <InputType>
 */
public interface IPipelineSubscriber<InputType extends Object> extends IPipelineComponent
{

	/**
	 * Receives a list of objects from a publisher
	 * @param items
	 * @throws IOException
	 * @throws Exception
	 */
	public void receive(List<InputType> items) throws IOException, Exception;

	/**
	 * Receives a single object from a publiser
	 * 
	 * @param item
	 * @throws IOException
	 * @throws Exception
	 */
	public void receive(InputType item) throws IOException, Exception;

	/**
	 * Sets the publisher for this subscriber
	 * 
	 * @param publisher
	 */
	public void setPublisher(IPipelinePublisher<InputType> publisher);
}
