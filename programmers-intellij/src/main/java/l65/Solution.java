package l65;

import java.math.BigDecimal;

class Solution {
	private String[] ignoreException =
			new String[] {"Exponent overflow.", "Too many nonzero exponent digits."};

	public boolean isNumber(String s) {
		try {
			new BigDecimal(s);
		} catch (Exception e) {
			for (String m : ignoreException) {
				if (e.getMessage() == m) {
					return true;
				}
			}
			return false;
		}
		return true;
	}
}
