package ru.trainings.common;

import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;



public class ReloadRule extends TestWatcher implements TestRule {
	private WebDriverRule driverRule;

	  public ReloadRule(WebDriverRule driverRule) {
	    this.driverRule = driverRule;
	  }
	  
  @Override
  public Statement apply(Statement base, Description desc) {
    return new ReloadStatement(base, desc);
  }

  public class ReloadStatement extends Statement {
    
    private final Statement base;
    private Description desc;
    
    public ReloadStatement(Statement base, Description desc) {
      this.base = base;
      this.desc = desc;
    }

    @Override
    public void evaluate() throws Throwable { 
    	try {
        base.evaluate();
      } catch (Throwable t) {
        System.out.println("Failed on attempt: " + desc);
        base.evaluate();
      }
    }

  }
}
