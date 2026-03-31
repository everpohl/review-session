package questions;

import common.ReviewSessionQuestions;
import common.ReviewSessionTestBase;

public class StudentsTest extends ReviewSessionTestBase {

    @Override
    protected ReviewSessionQuestions makeSubject() {
        return new Students();
    }
}
