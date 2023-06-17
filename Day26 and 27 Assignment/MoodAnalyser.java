package org.example;

public class MoodAnalyser {
    private String message;

    public MoodAnalyser() {
        this.message = "";
    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood() throws MoodAnalysisException {
        try {
            if (this.message == null || this.message.isEmpty()) {
                throw new MoodAnalysisException(MoodErrorType.INVALID_MOOD, "Invalid mood input!");
            }

            if (this.message.toLowerCase().contains("happy")) {
                return "HAPPY";
            } else if (this.message.toLowerCase().contains("sad")) {
                return "SAD";
            } else {
                return "UNKNOWN";
            }
        } catch (MoodAnalysisException e) {
            System.out.println("Exception: " + e.getMessage());
            throw e;
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        MoodAnalyser moodAnalyser1 = new MoodAnalyser("I am in Sad Mood");
        try {
            String result1 = moodAnalyser1.analyseMood();
            System.out.println(result1);  // Output: SAD
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }

        // Test Case 2
        MoodAnalyser moodAnalyser2 = new MoodAnalyser("I am in Happy Mood");
        try {
            String result2 = moodAnalyser2.analyseMood();
            System.out.println(result2);  // Output: HAPPY
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }

        // Test Case 3 - Invalid mood input (null)
        MoodAnalyser moodAnalyser3 = new MoodAnalyser(null);
        try {
            String result3 = moodAnalyser3.analyseMood();
            System.out.println(result3);
        } catch (MoodAnalysisException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

enum MoodErrorType {
    INVALID_MOOD
}

class MoodAnalysisException extends Exception {
    private MoodErrorType errorType;

    public MoodAnalysisException(MoodErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public MoodErrorType getErrorType() {
        return errorType;
    }
}
