package ffm.rest.client.enums;

public enum GradeLevel {
	KINDERGARTEN("Kindergarten", "K"), FIRST_GRADE("First grade", "1"), SECOND_GRADE("Second grade", "2"), THIRD_GRADE("Third grade", "3"), FOURTH_GRADE("Fourth grade", "4"), FIFTH_GRADE("Fifth grade", "5"), SIXTH_GRADE("Sixth grade", "6"), SEVENTH_GRADE("Seventh grade", "7"), EIGHTH_GRADE("Eighth grade", "8"), NINTH_GRADE("Ninth grade", "9"), TENTH_GRADE("Tenth grade", "10"), ELEVENTH_GRADE("Eleventh grade", "11"), TWELFTH_GRADE("Twelfth grade", "12"), GRADE_13("Grade 13", "13"), ADULT_EDUCATION("Adult Education"), EARLY_EDUCATION("Early Education"), INFANT_TODDLER("Infant/toddler"), OTHER("Other"), POSTSECONDARY("Postsecondary"), PRESCHOOL_PREKINDERGARTEN("Preschool/Prekindergarten"), TRANSITIONAL_KINDERGARTEN("Transitional Kindergarten"), UNGRADED("Ungraded"), NOT_AVAILABLE("Not Available");
	private String displayText;
	private String shortText;

	GradeLevel(String displayText, String shortDisplayText) {
		this.displayText = displayText;
		this.shortText = shortDisplayText;
	}

	GradeLevel(String displayText) {
		this.displayText = displayText;
		this.shortText = "";
	}

	public static GradeLevel get(String string) {
		for (GradeLevel gradeLevel : GradeLevel.values()) {
			if (gradeLevel.getDisplayText().equals(string)) return gradeLevel;
		}
		return null;
	}

	public static GradeLevel getByCode(String string) {
		for (GradeLevel gradeLevel : GradeLevel.values()) {
			if (gradeLevel.getShortDisplayText().equals(string)) return gradeLevel;
		}
		return null;
	}

	public static GradeLevel[] getK12() {
		return new GradeLevel[]{KINDERGARTEN, FIRST_GRADE, SECOND_GRADE, THIRD_GRADE, FOURTH_GRADE, FIFTH_GRADE, SIXTH_GRADE, SEVENTH_GRADE, EIGHTH_GRADE, NINTH_GRADE, TENTH_GRADE, ELEVENTH_GRADE, TWELFTH_GRADE};
	}

	public static GradeLevel[] getElementary() {
		return new GradeLevel[]{KINDERGARTEN, FIRST_GRADE, SECOND_GRADE, THIRD_GRADE, FOURTH_GRADE, FIFTH_GRADE};
	}

	public static GradeLevel[] getMiddleSchool() {
		return new GradeLevel[]{SIXTH_GRADE, SEVENTH_GRADE, EIGHTH_GRADE};
	}

	public static GradeLevel[] getHighSchool() {
		return new GradeLevel[]{NINTH_GRADE, TENTH_GRADE, ELEVENTH_GRADE, TWELFTH_GRADE};
	}

	public GradeLevel valueOfDisplayText(String s) {
		for (GradeLevel g : GradeLevel.values())
			if (s.toLowerCase().equals(g.getDisplayText().toLowerCase())) return g;
		return null;
	}

	public String getDisplayText() {
		return displayText;
	}

	public String getShortDisplayText() {
		return shortText;
	}
}
