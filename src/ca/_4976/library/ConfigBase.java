package ca._4976.library;

import edu.wpi.first.wpilibj.tables.ITable;

public class ConfigBase {

	protected ReferenceInt getKey(ITable table, String key, int back) {

		if (table.containsKey(key)) back = (int) table.getNumber(key, (double) back);

		else table.putNumber(key, (double) back);

		ReferenceInt i = new ReferenceInt(back);

		table.addTableListener((source, key1, value, isNew) -> { if (key.equals(key1)) i.value = value; });

		return i;
	}

	protected ReferenceDouble getKey(ITable table, String key, double back) {

		if (table.containsKey(key)) back = table.getNumber(key, back);

		else table.putNumber(key, back);

		ReferenceDouble d = new ReferenceDouble(back);

		table.addTableListener((source, key1, value, isNew) -> { if (key.equals(key1)) d.value = value; });

		return d;
	}

	protected ReferenceString getKey(ITable table, String key, String back) {

		if (table.containsKey(key)) back = table.getString(key, back);

		else table.putString(key, back);

		ReferenceString s = new ReferenceString(back);

		table.addTableListener((source, key1, value, isNew) -> { if (key.equals(key1)) s.value = value; });

		return s;
	}

	protected final class ReferenceInt extends Reference {

		protected ReferenceInt(int i) { value = i; }

		protected ReferenceInt() { value = 0; }

		public final int get() { return (int) value; }
	}

	protected final class ReferenceDouble extends Reference {

		protected ReferenceDouble(double d) { value = d; }

		protected ReferenceDouble() { value = 0.0; }

		public final double get() { return (double) value; }
	}

	protected final class ReferenceString extends Reference {

		protected ReferenceString(String s) { value = s; }

		protected ReferenceString() { value = ""; }

		public final String get() { return (String) value; }
	}

	private abstract class Reference { Object value; }
}
