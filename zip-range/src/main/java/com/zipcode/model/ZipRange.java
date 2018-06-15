package com.zipcode.model;

/**
 * Stores the upper and lower bound of Zip Range.
 *
 * @author GollaM
 */
public class ZipRange {

	/**
	 * The lowerBound value.
	 */
	private int lowerBound;

	/**
	 * The upperBound value.
	 */
	private int upperBound;

	/**
	 * Constructor for ZipRange
	 * 
	 * Reverses the lowerBound and upperBound if they are out of order.
	 * 
	 * @param lowerBound
	 *            The lowerBound value
	 * @param upperBound
	 *            The upperBound value
	 */
	public ZipRange(final String lowerBound, final String upperBound) {
		
		checkLength(lowerBound, upperBound);

		int lBound, uBound;
		try {
			lBound = Integer.parseInt(lowerBound);
		} catch(final NumberFormatException nfe) {
			throw new IllegalArgumentException("Invalid lowerbound ZIP code: " + lowerBound + " . Should contain only digits.");
		}
		
		try {
			uBound = Integer.parseInt(upperBound);
		} catch(final NumberFormatException nfe) {
			throw new IllegalArgumentException("Invalid upperBound ZIP code: " + upperBound + " . Should contain only digits.");
		}
		
		// check if lower and upper bound are in reverse order
		if (lBound <= uBound) {
			this.lowerBound = lBound;
			this.upperBound = uBound;
		} else {
			this.lowerBound = uBound;
			this.upperBound = lBound;
		}
		
	}

	/**
	 * Validates length of Zip codes. Zip code should always be 5 digit.
	 * 
	 * @param lowerBound
	 *            the lowerbound value
	 * @param upperBound
	 *            the upperBound value
	 */
	private void checkLength(final String lowerBound, final String upperBound) {
		
		if ( lowerBound.length() < 5 || lowerBound.length() > 5 ) {
			throw new IllegalArgumentException("Invalid lowerbound ZIP code: " + lowerBound);
		} else if( upperBound.length() < 5 || upperBound.length() > 5 ) {
			throw new IllegalArgumentException("Invalid upperbound ZIP code: " + upperBound);
		} 
		
	}

	/**
	 * Returns the lowerBound
	 * 
	 * @return lowerBound value
	 */
	public int getLowerBound() {
		return lowerBound;
	}

	/**
	 * Sets the lowerBound
	 * 
	 * @param lowerBound - the lowerBound value
	 */
	public void setLowerBound(final int lowerBound) {
		this.lowerBound = lowerBound;
	}

	/**
	 * Returns the upperBound
	 * 
	 * @return upperBound value
	 */
	public int getUpperBound() {
		return upperBound;
	}

	/**
	 * Sets the upperBound
	 * 
	 * @param upperBound - the upperBound value
	 */
	public void setUpperBound(final int upperBound) {
		this.upperBound = upperBound;
	}

	/**
	 * Returns the String representation of the @ZipRange instance.
	 */
	@Override
	public String toString() {
		return String.format("['%05d','%05d']", lowerBound, upperBound);
	}

	/**
	 * Equals method
	 */
	@Override
	public boolean equals(final Object object) {
		final ZipRange range = (ZipRange) object;
		return range.getLowerBound() == this.lowerBound && range.getUpperBound() == this.upperBound;

	}
	
	/**
	 * HashCode method
	 */
	@Override
	public int hashCode() {
		return this.lowerBound * 7 + this.upperBound * 13;

	}
}
