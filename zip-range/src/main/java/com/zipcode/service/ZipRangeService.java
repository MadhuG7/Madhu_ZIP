package com.zipcode.service;

import java.util.List;

import com.zipcode.model.ZipRange;

/**
 * Interface for managing ZipRange list. Contains methods to add ZipRange to
 * existing list of ZipRange and get List of ZipRange.
 *
 * @author GollaM
 */
public interface ZipRangeService {

	/**
	 * Adds the new ZipRange to the existing list.
	 * 
	 * @param range
	 * 			ZipRange to be added.
	 */
	public void addZipRange(final ZipRange range);

	/**
	 * Returns the list of ZipRange
	 * 
	 * @return List - the list of ZipRange
	 */
	public List<ZipRange> getZipRanges();

}
