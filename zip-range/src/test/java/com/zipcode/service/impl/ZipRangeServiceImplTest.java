package com.zipcode.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import com.zipcode.model.ZipRange;
import com.zipcode.service.ZipRangeService;

/**
 * Unit test case for ZipRangeServiceImpl
 *
 * @author GollaM
 */
@RunWith(DataProviderRunner.class)
public class ZipRangeServiceImplTest {

	/**
	 * Class under test
	 */
	private ZipRangeService zipRangeService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() {
		zipRangeService = new ZipRangeServiceImpl();
	}

	@Test
	@UseDataProvider("exclusive1")
	public void exclusiveTest1(List<ZipRange> ranges, List<ZipRange> expectedResult) {
		for (ZipRange range : ranges) {
			zipRangeService.addZipRange(range);
		}

		List<ZipRange> result = zipRangeService.getZipRanges();
		Assert.assertEquals(result, expectedResult);
	}

	@Test
	@UseDataProvider("overlap1")
	public void overlapTest1(List<ZipRange> ranges, List<ZipRange> expectedResult) {
		for (ZipRange range : ranges) {
			zipRangeService.addZipRange(range);
		}

		List<ZipRange> result = zipRangeService.getZipRanges();
		Assert.assertEquals(result, expectedResult);
	}

	@Test
	@UseDataProvider("inclusive1")
	public void inclusiveTest1(List<ZipRange> ranges, List<ZipRange> expectedResult) {
		for (ZipRange range : ranges) {
			zipRangeService.addZipRange(range);
		}

		List<ZipRange> result = zipRangeService.getZipRanges();
		Assert.assertEquals(result, expectedResult);
	}

	@Test
	@UseDataProvider("reverseOrderRange1")
	public void reverseOrderRangeTest1(List<ZipRange> ranges, List<ZipRange> expectedResult) {
		for (ZipRange range : ranges) {
			zipRangeService.addZipRange(range);
		}

		List<ZipRange> result = zipRangeService.getZipRanges();
		Assert.assertEquals(result, expectedResult);
	}

	@Test
	@UseDataProvider("reverseOrderInclusiveRange1")
	public void reverseOrderInclusiveRangeTest1(List<ZipRange> ranges, List<ZipRange> expectedResult) {
		for (ZipRange range : ranges) {
			zipRangeService.addZipRange(range);
		}

		List<ZipRange> result = zipRangeService.getZipRanges();
		Assert.assertEquals(result, expectedResult);
	}

	@Test
	@UseDataProvider("mixedRange1")
	public void mixedRangeTest1(List<ZipRange> ranges, List<ZipRange> expectedResult) {
		for (ZipRange range : ranges) {
			zipRangeService.addZipRange(range);
		}

		List<ZipRange> result = zipRangeService.getZipRanges();
		Assert.assertEquals(result, expectedResult);
	}

	/*
	 * Invalid Lengths
	 */

	@Test
	public void invalidInboundValueSmallerTest() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Invalid lowerbound ZIP code: 1100");
		zipRangeService.addZipRange(new ZipRange("1100", "20000"));
	}

	@Test
	public void invalidOutboundValueSmallerTest() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Invalid upperbound ZIP code: 2000");
		zipRangeService.addZipRange(new ZipRange("11224", "2000"));
	}

	@Test
	public void invalidInboundValueLargerTest() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Invalid lowerbound ZIP code: 112241");
		zipRangeService.addZipRange(new ZipRange("112241", "20000"));
	}

	@Test
	public void invalidOutboundValueLargerTest() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Invalid upperbound ZIP code: 200000");
		zipRangeService.addZipRange(new ZipRange("11224", "200000"));
	}

	/*
	 * Data Providers
	 */

	@DataProvider
	public static List<List<List<Object>>> exclusive1() {
		List<Object> ranges1 = new ArrayList<>();
		ranges1.add(new ZipRange("10000", "20000"));
		ranges1.add(new ZipRange("21000", "30000"));
		ranges1.add(new ZipRange("31000", "40000"));

		List<Object> expectedResult1 = new ArrayList<>();
		expectedResult1.add(new ZipRange("10000","20000"));
		expectedResult1.add(new ZipRange("21000","30000"));
		expectedResult1.add(new ZipRange("31000","40000"));

		List<List<Object>> list1 = new ArrayList<>();
		list1.add(ranges1);
		list1.add(expectedResult1);
		
		List<List<List<Object>>> data = new ArrayList<>();
		data.add(list1);
		return data;

	}

	@DataProvider
	public static List<List<List<Object>>> overlap1() {
		List<Object> ranges1 = new ArrayList<>();
		ranges1.add(new ZipRange("10000", "20000"));
		ranges1.add(new ZipRange("15000", "30000"));
		ranges1.add(new ZipRange("20000", "40000"));

		List<Object> expectedResult1 = new ArrayList<>();
		expectedResult1.add(new ZipRange("10000","40000"));

		List<Object> ranges2 = new ArrayList<>();
		ranges2.add(new ZipRange("10000", "20000"));
		ranges2.add(new ZipRange("20000", "30000"));
		ranges2.add(new ZipRange("30000", "40000"));

		List<Object> expectedResult2 = new ArrayList<>();
		expectedResult2.add(new ZipRange("10000","40000"));

		List<List<Object>> list1 = new ArrayList<>();
		list1.add(ranges1);
		list1.add(expectedResult1);
		
		List<List<Object>> list2 = new ArrayList<>();
		list2.add(ranges2);
		list2.add(expectedResult2);
		
		List<List<List<Object>>> data = new ArrayList<>();
		data.add(list1);
		data.add(list2);
		return data;

	}

	@DataProvider
	public static List<List<List<Object>>> inclusive1() {
		List<Object> ranges = new ArrayList<>();
		ranges.add(new ZipRange("10000", "20000"));
		ranges.add(new ZipRange("10002", "10008"));
		ranges.add(new ZipRange("11000", "19000"));

		List<Object> expectedResult1 = new ArrayList<>();
		expectedResult1.add(new ZipRange("10000","20000"));
		
		List<List<Object>> list1 = new ArrayList<>();
		list1.add(ranges);
		list1.add(expectedResult1);
		
		List<List<List<Object>>> data = new ArrayList<>();
		data.add(list1);
		return data;

	}

	@DataProvider
	public static List<List<List<Object>>> reverseOrderRange1() {
		List<Object> ranges = new ArrayList<>();
		ranges.add(new ZipRange("20000", "10000"));
		ranges.add(new ZipRange("40000", "30000"));
		ranges.add(new ZipRange("70000", "60000"));

		List<Object> expectedResult1 = new ArrayList<>();
		expectedResult1.add(new ZipRange("10000","20000"));
		expectedResult1.add(new ZipRange("30000","40000"));
		expectedResult1.add(new ZipRange("60000","70000"));
		
		List<List<Object>> list1 = new ArrayList<>();
		list1.add(ranges);
		list1.add(expectedResult1);
		
		List<List<List<Object>>> data = new ArrayList<>();
		data.add(list1);
		return data;

	}

	@DataProvider
	public static List<List<List<Object>>> reverseOrderInclusiveRange1() {
		List<Object> ranges = new ArrayList<>();
		ranges.add(new ZipRange("20000", "10000"));
		ranges.add(new ZipRange("12000", "11000"));
		ranges.add(new ZipRange("70000", "60000"));

		List<Object> expectedResult1 = new ArrayList<>();
		expectedResult1.add(new ZipRange("10000","20000"));
		expectedResult1.add(new ZipRange("60000","70000"));
		
		List<List<Object>> list1 = new ArrayList<>();
		list1.add(ranges);
		list1.add(expectedResult1);
		
		List<List<List<Object>>> data = new ArrayList<>();
		data.add(list1);
		return data;

	}

	@DataProvider
	public static List<List<List<Object>>> mixedRange1() {
		List<Object> ranges1 = new ArrayList<>();
		ranges1.add(new ZipRange("20000", "11011"));
		ranges1.add(new ZipRange("12333", "11001"));
		ranges1.add(new ZipRange("70000", "60000"));
		ranges1.add(new ZipRange("62234", "65000"));
		ranges1.add(new ZipRange("22444", "25000"));
		ranges1.add(new ZipRange("35338", "65000"));
		
		List<Object> expectedResult1 = new ArrayList<>();
		expectedResult1.add(new ZipRange("11001","20000"));
		expectedResult1.add(new ZipRange("22444","25000"));
		expectedResult1.add(new ZipRange("35338","70000"));
		
		List<Object> ranges2 = new ArrayList<>();
		ranges2.add(new ZipRange("45500","45590"));
		ranges2.add(new ZipRange("46999","47900"));
		ranges2.add(new ZipRange("44000","45000"));
		ranges2.add(new ZipRange("43000","46555"));
		
		List<Object> expectedResult2 = new ArrayList<>();
		expectedResult2.add(new ZipRange("46999","47900"));
		expectedResult2.add(new ZipRange("43000","46555"));
		
		List<List<Object>> list1 = new ArrayList<>();
		list1.add(ranges1);
		list1.add(expectedResult1);
		
		List<List<Object>> list2 = new ArrayList<>();
		list2.add(ranges2);
		list2.add(expectedResult2);
		
		List<List<List<Object>>> data = new ArrayList<>();
		data.add(list1);
		data.add(list2);
		return data;

	}
}
