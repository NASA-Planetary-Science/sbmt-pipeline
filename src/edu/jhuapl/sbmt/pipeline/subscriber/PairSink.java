package edu.jhuapl.sbmt.pipeline.subscriber;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import edu.jhuapl.sbmt.pipeline.publisher.IPipelinePublisher;

/**
 * Similar to a <code>Sink</code>, but holds a pair of values.
 * 
 * @param <L>
 * @param <R>
 * @param <O>
 */
public class PairSink<L extends Object, R extends Object, O extends Object> implements IPipelineSubscriber<Pair<L, R>>
{
	/**
	 * The publisher for this subscriber
	 */
	private IPipelinePublisher<Pair<L, R>> publisher;
	
	
	/**
	 * The array of pairs representing the outputs of this <code>PairSink</code>
	 */
	private Pair<L, R>[] outputs;

	/**
	 * Static helper method to build a <p>PairSink</p>
	 * 
	 * @param <L>
	 * @param <R>
	 * @param <O>
	 * @param outputs
	 * @return
	 */
	public static <L extends Object, R extends Object, O extends Object> PairSink<L, R, O> of(Pair<L, R>[] outputs)
	{
		return new PairSink<L, R, O>(outputs);
	}

	/**
	 * Constructor that takes in an array of Pairs to build the PairSink
	 * 
	 * @param outputs
	 */
	public PairSink(Pair<L, R>[] outputs)
	{
		this.outputs = outputs;
	}

	@Override
	public void receive(List<Pair<L, R>> items)
	{
		int i=0;
		for (Pair<L,R> pair : items)
		{
			this.outputs[i++] = Pair.of(pair.getLeft(), pair.getRight());
		}
	}

	@Override
	public void receive(Pair<L, R> item)
	{
		receive(List.of(item));
	}

	@Override
	public void setPublisher(IPipelinePublisher<Pair<L, R>> publisher)
	{
		this.publisher = publisher;
	}

	@Override
	public PairSink<L, R, O> run() throws IOException, Exception
	{
		publisher.run();
		return this;
	}

//	@Override
//	public PairSink<L, R, O> run(Runnable completion) throws IOException, Exception
//	{
//		publisher.run();
//		completion.run();
//		return this;
//	}

//	@Override
//	public Pair<L, R> drip()
//	{
//		return outputs[0];
//	}
//
//	@Override
//	public List<Pair<L, R>> flow()
//	{
//		return List.of(outputs);
//	}

}
