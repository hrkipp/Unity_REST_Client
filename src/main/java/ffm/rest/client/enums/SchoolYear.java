package ffm.rest.client.enums;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public enum SchoolYear {
	_1996_1997("1996-1997"),
	_1997_1998("1997-1998"),
	_1998_1999("1998-1999"),
	_1999_2000("1999-2000"),
	_2000_2001("2000-2001"),
	_2001_2002("2001-2002"),
	_2002_2003("2002-2003"),
	_2003_2004("2003-2004"),
	_2004_2005("2004-2005"),
	_2005_2006("2005-2006"),
	_2006_2007("2006-2007"),
	_2007_2008("2007-2008"),
	_2008_2009("2008-2009"),
	_2009_2010("2009-2010"),
	_2010_2011("2010-2011"),
	_2011_2012("2011-2012"),
	_2012_2013("2012-2013"),
	_2013_2014("2013-2014"),
	_2014_2015("2014-2015"),
	_2015_2016("2015-2016"),
	_2016_2017("2016-2017"),
	_2017_2018("2017-2018"),
	_2018_2019("2018-2019"),
	_2019_2020("2019-2020"),
	_2021_2022("2021-2022"),
	_2022_2023("2022-2023"),
	_2023_2024("2023-2024"),
	_2024_2025("2024-2025"),
	_2025_2026("2025-2026"),
	_2026_2027("2026-2027"),
	_2027_2028("2027-2028"),
	_2028_2029("2028-2029"),
	_2029_2030("2029-2030");

	private String prettyName;

	SchoolYear(String prettyName) {
		this.prettyName = prettyName;
	}

	public SchoolYear backtrack(GradeLevel gradeLevel) {
		return values()[ordinal() - gradeLevel.ordinal()];
	}

	public String getDisplayText() {
		return prettyName;
	}

	public static SchoolYear current() {
		return get(new Date());
	}

	public static SchoolYear get(Date date) {
		if (date.getMonth() > 5) {
			return values()[date.getYear() - 96];
		} else {
			return values()[date.getYear() - 97];
		}
	}

	public Date getStart(){
		return new Date(ordinal() + 96, 6, 1);
	}

	public Date getEnd(){
		return new Date(ordinal() + 97, 5, 30);
	}

	//Returns all school years
	public static List<SchoolYear> getSchoolYearOccurances(){
		List<SchoolYear> ret = new ArrayList<>();
		SchoolYear current = current();
		for(SchoolYear s : values()) {
			ret.add(s);
			if(s.equals(current)) break;
		}
		return ret;
	}

}