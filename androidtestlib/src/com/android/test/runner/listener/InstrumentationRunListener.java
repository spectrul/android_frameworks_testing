/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.test.runner.listener;

import android.app.Instrumentation;
import android.os.Bundle;

import org.junit.runner.notification.RunListener;

import java.io.PrintStream;

/**
 * A {@link RunListener} that has access to a {@link Instrumentation}. This is useful for
 * test result listeners that want to dump data back to the instrumentation results.
 */
public abstract class InstrumentationRunListener extends RunListener {

    private final Instrumentation mInstr;

    public InstrumentationRunListener(Instrumentation instr) {
        mInstr = instr;
    }

    public Instrumentation getInstrumentation() {
        return mInstr;
    }

    /**
     * Convenience method for {@link #getInstrumentation()#sendStatus()}
     */
    public void sendStatus(int code, Bundle bundle) {
        getInstrumentation().sendStatus(code, bundle);
    }

    /**
     * Optional callback subclasses can implement. Will be called when instrumentation run
     * completes.
     *
     * @param streamResult the {@link PrintStream} to instrumentation out.
     * @param resultBundle the instrumentation result bundle. Can be used to inject key-value pairs
     * into the instrumentation output when run in -r/raw mode
     */
    public void instrumentationRunFinished(PrintStream streamResult, Bundle resultBundle) {
    }
}
