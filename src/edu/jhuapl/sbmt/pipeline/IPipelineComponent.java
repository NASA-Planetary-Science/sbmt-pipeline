package edu.jhuapl.sbmt.pipeline;

import java.io.IOException;

public interface IPipelineComponent
{
	public IPipelineComponent run() throws IOException, Exception;
}
