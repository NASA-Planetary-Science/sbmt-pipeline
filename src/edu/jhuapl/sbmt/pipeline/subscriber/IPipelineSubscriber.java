package edu.jhuapl.sbmt.pipeline.subscriber;

import java.io.IOException;
import java.util.List;

import edu.jhuapl.sbmt.pipeline.IPipelineComponent;
import edu.jhuapl.sbmt.pipeline.publisher.IPipelinePublisher;

public interface IPipelineSubscriber<InputType extends Object> extends IPipelineComponent
{

	public void receive(List<InputType> items) throws IOException, Exception;

	public void receive(InputType item) throws IOException, Exception;

	public void setPublisher(IPipelinePublisher<InputType> publisher);

//	public InputType drip();
//
//	public List<InputType> flow();
}
