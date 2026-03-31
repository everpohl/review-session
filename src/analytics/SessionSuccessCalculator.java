package analytics;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility for summarizing review-session outcomes using a repeatable score.
 *
 * This is not meant to be a rigorous research instrument. It is a lightweight
 * way to compare sessions over time and notice whether changes to pacing,
 * prompts, or scaffolding improved the experience.
 *
 * @author Everett
 * @version Mar 31, 2026
 */
public final class SessionSuccessCalculator {

    private SessionSuccessCalculator() {
        // Utility class.
    }

    /**
     * Computes a 0-100 session success score using four simple signals:
     * completion, confidence gain, pacing satisfaction, and question-asking.
     *
     * @param studentsPresent total number of students in attendance
     * @param totalProblems total number of problems attempted in the session
     * @param completedProblems total number of problem completions across all
     *            students
     * @param averageConfidenceBefore average pre-session confidence from 1 to 5
     * @param averageConfidenceAfter average post-session confidence from 1 to 5
     * @param studentsSatisfiedWithPacing number of students who said the pacing
     *            felt appropriate
     * @param studentsWhoAskedQuestions number of students who asked at least one
     *            question
     * @return rounded success score from 0 to 100
     * @throws IllegalArgumentException if the inputs are out of range
     */
    public static int calculateSuccessScore(int studentsPresent, int totalProblems,
            int completedProblems, double averageConfidenceBefore,
            double averageConfidenceAfter, int studentsSatisfiedWithPacing,
            int studentsWhoAskedQuestions) {

        validateInputs(studentsPresent, totalProblems, completedProblems,
                averageConfidenceBefore, averageConfidenceAfter,
                studentsSatisfiedWithPacing, studentsWhoAskedQuestions);

        double totalPossibleCompletions = studentsPresent * totalProblems;
        double completionRate = completedProblems / totalPossibleCompletions;
        double confidenceGain = (averageConfidenceAfter - averageConfidenceBefore)
                / 4.0;
        double pacingSatisfactionRate = studentsSatisfiedWithPacing
                / (double) studentsPresent;
        double questionParticipationRate = studentsWhoAskedQuestions
                / (double) studentsPresent;

        double weightedScore = completionRate * 0.40
                + clamp(confidenceGain, 0.0, 1.0) * 0.30
                + pacingSatisfactionRate * 0.20
                + questionParticipationRate * 0.10;

        return (int) Math.round(weightedScore * 100);
    }

    /**
     * Creates a compact metric summary that can be printed or logged.
     *
     * @param studentsPresent total number of students in attendance
     * @param totalProblems total number of problems attempted in the session
     * @param completedProblems total number of problem completions across all
     *            students
     * @param averageConfidenceBefore average pre-session confidence from 1 to 5
     * @param averageConfidenceAfter average post-session confidence from 1 to 5
     * @param studentsSatisfiedWithPacing number of students who said the pacing
     *            felt appropriate
     * @param studentsWhoAskedQuestions number of students who asked at least one
     *            question
     * @return map of named metrics for comparison between sessions
     */
    public static Map<String, Double> summarizeMetrics(int studentsPresent,
            int totalProblems, int completedProblems,
            double averageConfidenceBefore, double averageConfidenceAfter,
            int studentsSatisfiedWithPacing, int studentsWhoAskedQuestions) {

        validateInputs(studentsPresent, totalProblems, completedProblems,
                averageConfidenceBefore, averageConfidenceAfter,
                studentsSatisfiedWithPacing, studentsWhoAskedQuestions);

        Map<String, Double> metrics = new HashMap<String, Double>();
        double totalPossibleCompletions = studentsPresent * totalProblems;

        metrics.put("completionRate", completedProblems / totalPossibleCompletions);
        metrics.put("confidenceBefore", averageConfidenceBefore);
        metrics.put("confidenceAfter", averageConfidenceAfter);
        metrics.put("confidenceGain",
                averageConfidenceAfter - averageConfidenceBefore);
        metrics.put("pacingSatisfactionRate",
                studentsSatisfiedWithPacing / (double) studentsPresent);
        metrics.put("questionParticipationRate",
                studentsWhoAskedQuestions / (double) studentsPresent);
        metrics.put("successScore",
                (double) calculateSuccessScore(studentsPresent, totalProblems,
                        completedProblems, averageConfidenceBefore,
                        averageConfidenceAfter, studentsSatisfiedWithPacing,
                        studentsWhoAskedQuestions));
        return metrics;
    }

    private static void validateInputs(int studentsPresent, int totalProblems,
            int completedProblems, double averageConfidenceBefore,
            double averageConfidenceAfter, int studentsSatisfiedWithPacing,
            int studentsWhoAskedQuestions) {

        if (studentsPresent <= 0) {
            throw new IllegalArgumentException(
                    "studentsPresent must be greater than zero.");
        }
        if (totalProblems <= 0) {
            throw new IllegalArgumentException(
                    "totalProblems must be greater than zero.");
        }
        if (completedProblems < 0
                || completedProblems > studentsPresent * totalProblems) {
            throw new IllegalArgumentException(
                    "completedProblems must be between 0 and the total possible completions.");
        }
        if (averageConfidenceBefore < 1.0 || averageConfidenceBefore > 5.0) {
            throw new IllegalArgumentException(
                    "averageConfidenceBefore must be between 1 and 5.");
        }
        if (averageConfidenceAfter < 1.0 || averageConfidenceAfter > 5.0) {
            throw new IllegalArgumentException(
                    "averageConfidenceAfter must be between 1 and 5.");
        }
        if (studentsSatisfiedWithPacing < 0
                || studentsSatisfiedWithPacing > studentsPresent) {
            throw new IllegalArgumentException(
                    "studentsSatisfiedWithPacing must be between 0 and studentsPresent.");
        }
        if (studentsWhoAskedQuestions < 0
                || studentsWhoAskedQuestions > studentsPresent) {
            throw new IllegalArgumentException(
                    "studentsWhoAskedQuestions must be between 0 and studentsPresent.");
        }
    }

    private static double clamp(double value, double min, double max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }
}
