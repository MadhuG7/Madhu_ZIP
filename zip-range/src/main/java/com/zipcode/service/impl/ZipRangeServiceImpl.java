package com.zipcode.service.impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.zipcode.model.ZipRange;
import com.zipcode.service.ZipRangeService;

/**
 * Implementation of ZipRangeService for managing ZipRange list. Contains methods
 * to add ZipRange to existing list of ZipRange and get List of ZipRange.
 *
 * @author GollaM
 */
public class ZipRangeServiceImpl implements ZipRangeService {

	final static Logger logger = Logger.getLogger(ZipRangeServiceImpl.class);
	
	/**
	 * List of ZipRange
	 */
	private List<ZipRange> rangeList = new LinkedList<ZipRange>();

	/**
	 * Adds the new ZipRange to the existing list.
	 * 
	 * @param range
	 * ZipRange to be added.
	 */
	public void addZipRange(final ZipRange range) {
		add(range);
	}

	/**
	 * Adds the new ZipRange in existing list.
	 * 
	 * Checks if the new range <br>
	 * 1. Falls inside an existing range or <br>
	 * 2. Extends an existing range or <br>
	 * 3. Is a completely new range
	 * 
	 * @param newRangeToAdd
	 *            The new ZipRange to add
	 */
	private void add(final ZipRange newRangeToAdd) {

		logger.debug("New Range to be added : "+newRangeToAdd);
		
		boolean shouldAdd = true;
		final Iterator<ZipRange> it = rangeList.iterator();
		while( it.hasNext() ) {
			final ZipRange range = it.next();
			
			if (range.getLowerBound() > newRangeToAdd.getUpperBound()
					|| range.getUpperBound() < newRangeToAdd.getLowerBound()) {
				shouldAdd = true;
			} else if (range.getLowerBound() <= newRangeToAdd.getLowerBound()
					&& range.getUpperBound() >= newRangeToAdd.getUpperBound()) {
				shouldAdd = false;
			} else {
				if (range.getLowerBound() < newRangeToAdd.getLowerBound())
					newRangeToAdd.setLowerBound(range.getLowerBound());
				if (range.getUpperBound() > newRangeToAdd.getUpperBound())
					newRangeToAdd.setUpperBound(range.getUpperBound());
				it.remove();
				shouldAdd = true;
				logger.debug("New Range value changed to : "+newRangeToAdd);
			}
		}

		
		if (shouldAdd) {
			logger.debug("New Range added : "+newRangeToAdd);
			rangeList.add(newRangeToAdd);
		}
	}

	/**
	 * Returns the list of ZipRange
	 * 
	 * @return List - list of ZipRange
	 */
	public List<ZipRange> getZipRanges() {
		return rangeList;
	}
}
