package ir.sk.algorithm.stack.parsingarithmeticexpression;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/2/2021.
 */
public class ExpressionTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void infixIntoPostfixExp() {
        System.out.println(Expression.infixIntoPostfixExp("((2+3)*(4+5))"));
    }

    @Test
    public void postfixEvaluation() {
        System.out.println(Expression.postfixEvaluation("23+45+*"));
    }
}