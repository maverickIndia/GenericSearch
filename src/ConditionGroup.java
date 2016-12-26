import java.util.List;

/**
 * 
 */

/**
 * @author PRASAD
 *
 */
public class ConditionGroup  
{
	public String logicalOperator;
	
	public List<ConditionGroup> conditionGroups;
	
	public List<Condition> conditions;

	public String getLogicalOperator() {
		return logicalOperator;
	}

	public void setLogicalOperator(String logicalOperator) {
		this.logicalOperator = logicalOperator;
	}

	public List<ConditionGroup> getConditionGroups() {
		return conditionGroups;
	}

	public void setConditionGroups(List<ConditionGroup> conditionGroups) {
		this.conditionGroups = conditionGroups;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}
}
