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

import com.google.common.base.Optional;

import java.net.URI;

/**
 * Manages and Executes Print Jobs.
 *
 * Created by Jesse on 3/17/14.
 */
public interface JobManager {
    /**
     * Submit a new job for execution.
     *
     * @param job the job to run.
     */
    void submit(PrintJob job);

    /**
     * Get the number of prints that finished (either by error or success).
     */
    int getLastPrintCount();

    /**
     * Get the average time print jobs take to complete.
     */
    long getAverageTimeSpentPrinting();

    /**
     * Get the total number of print requests made.
     */
    int getNumberOfRequestsMade();

    /**
     * get the URI for loading the report data.
     *
     * @param referenceId the reference string of the report.
     */
    URI getURI(String referenceId);

    /**
     * Get the time since a client has last requested the print job.
     *
     * @param referenceId the id of the printjob
     */
    long timeSinceLastStatusCheck(String referenceId);

    /**
     * Check if the job is done.
     *
     * @param referenceId the job to check.
     */
    boolean isDone(String referenceId);

    /**
     * Return the completed job object if the job has completed or absent otherwise.
     *
     * @param referenceId the referenceId of the report to lookup
     */
    Optional<? extends CompletedPrintJob> getCompletedPrintJob(String referenceId);
}
