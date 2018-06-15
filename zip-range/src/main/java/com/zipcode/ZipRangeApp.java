package com.zipcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zipcode.model.ZipRange;
import com.zipcode.service.ZipRangeService;
import com.zipcode.service.impl.ZipRangeServiceImpl;

/**
 * Driver class to run the app.
 * 
 * @author GollaM
 */
public class ZipRangeApp {

	public static void main(String[] args) {

		final ZipRangeService zipRangeService = new ZipRangeServiceImpl();

		final Pattern p = Pattern.compile("\\[([^]]+)\\]");

		try (InputStreamReader isr = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(isr)) {
			final String input = br.readLine().trim();
			
			final Matcher m = p.matcher(input);
			while (m.find()) {
				final String[] s = m.group().replaceAll("[\\[\\]\\s+]", "").split(",");
				zipRangeService.addZipRange(new ZipRange(s[0], s[1]));
			}

		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace(System.err);
		}

		for (final ZipRange range : zipRangeService.getZipRanges()) {
			System.out.print("[" + range.getLowerBound() + "," + range.getUpperBound() + "] ");
		}
	}

}
