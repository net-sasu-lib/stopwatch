package net.sasu.lib.time.stopwatch.example;

import net.sasu.lib.time.stopwatch.stateful.FinishedStatefulStopwatch;
import net.sasu.lib.time.stopwatch.stateful.InitializedStatefulStopwatch;
import net.sasu.lib.time.stopwatch.stateful.StartedStatefulStopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultStopwatchExample {

	public static void  main(String[] args) throws InterruptedException {
		InitializedStatefulStopwatch swInitialized = new InitializedStatefulStopwatch();

		StartedStatefulStopwatch swStarted = swInitialized.start();
		//DefaultStopwatch stopwatch = new DefaultStopwatch().start();
		Thread.sleep(1111); //let 1.111 seconds elapse

		//prints elapsed time to default output target (system out) in format HH:mm:ss.SSS
		//this prints "00:00:01.111"
		//stopwatch.stop().elapsedTime().println();
		swStarted.getElapsedTime().println();

		Thread.sleep(1000); //let 1 second elapse while stopwatch is still running

		//let's stop the watch and print the time explicitly to system out
		FinishedStatefulStopwatch swFinished = swStarted.stop();
		swFinished.getElapsedTime().printTo(System.out::println);

		//or maybe you want to use a Logger (e.g. SLF4J) instead?
		Logger logger = LoggerFactory.getLogger(DefaultStopwatchExample.class);
		swStarted.getElapsedTime().printTo(logger::info);

		//you can apply individual formatting (see Apache DurationFormatUtils for syntax)
		//this prints "1 seconds and 111 milliseconds"
		//stopwatch.elapsedTime().formatDuration("s' seconds and 'S' milliseconds'").println();

		//this prints "1.111 s"
		//stopwatch.elapsedTime().formatDuration("s'.'SSS' s'").println();
	}
	
}
