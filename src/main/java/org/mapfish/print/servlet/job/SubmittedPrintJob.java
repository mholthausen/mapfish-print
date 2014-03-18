/*
 * Copyright (C) 2014  Camptocamp
 *
 * This file is part of MapFish Print
 *
 * MapFish Print is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MapFish Print is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MapFish Print.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.mapfish.print.servlet.job;

import java.util.Date;
import java.util.concurrent.Future;

/**
 * Encapsulates a job that has been submitted to the JobManager.
 *
 * Created by Jesse on 3/18/14.
 */
public class SubmittedPrintJob {
    private final String reportRef;
    private final Future<CompletedPrintJob> reportFuture;
    private final long startTime;

    /**
     * Constructor.
     *
     * @param reportFuture the future for checking if the report is done and for getting the uri
     * @param reportRef the unique ID for the report
     */
    public SubmittedPrintJob(final Future<CompletedPrintJob> reportFuture, final String reportRef) {
        this.startTime = new Date().getTime();
        this.reportFuture = reportFuture;
        this.reportRef = reportRef;
    }

    /**
     * Get the unique ID for the report.
     */
    public final String getReportRef() {
        return this.reportRef;
    }

    /**
     * Get the future for checking if the report is done and for getting the uri.
     */
    public final Future<CompletedPrintJob> getReportFuture() {
        return this.reportFuture;
    }

    public final long getTimeSinceStart() {
        return System.currentTimeMillis() - this.startTime;
    }
}
