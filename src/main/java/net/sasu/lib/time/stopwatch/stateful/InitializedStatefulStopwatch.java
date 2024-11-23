package net.sasu.lib.time.stopwatch.stateful;

import java.time.Instant;

public class InitializedStatefulStopwatch {

    public StartedStatefulStopwatch start() {
        return new StartedStatefulStopwatch();
    }
}
