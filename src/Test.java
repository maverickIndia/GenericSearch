import java.util.ArrayList;
import java.util.List;


public class Test {

	public static StringBuffer s = new StringBuffer();
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int j=1;
		
		ConditionGroup cg1=new ConditionGroup();
		
		cg1.setLogicalOperator("AND");
		List<Condition> conditions=new  ArrayList<>();
		addCondition(conditions, j++);
		addCondition(conditions, j++);
		
		cg1.setConditions(conditions);
		
		List<ConditionGroup> cgList=new ArrayList<ConditionGroup>();
		j=addConditionGroup(j, cgList);
		j=addConditionGroup(j, cgList);
		
		cg1.setConditionGroups(cgList);
		
		
		evaluate(cg1.getConditions(), cg1.getConditionGroups(), cg1.getLogicalOperator());
		
		System.out.println(s.toString());
	}

	private static int addConditionGroup(int j, List<ConditionGroup> cgList) {
		ConditionGroup cg2=new ConditionGroup();
		cg2.setLogicalOperator("OR");
		
		List<Condition> conditions1=new  ArrayList<>();
		addCondition(conditions1, j++);
		addCondition(conditions1, j++);

		cg2.setConditions(conditions1);
		cgList.add(cg2);
		
		return j;
	}

	private static void addCondition(List<Condition> conditions, int i) 
	{
		Condition condition1=new Condition();
		condition1.setSearchColumn("C"+i);
		condition1.setSearchValue("V"+i);
		condition1.setOperator(" = ");
		conditions.add(condition1);
	}

	public static void evaluate(List<Condition> conditions, List<ConditionGroup> condtionGroups, String logicalOpt)
	{
		if(null == condtionGroups)
		{
			decodeConditions(conditions, logicalOpt);
		}
		
		else
		{
			for(ConditionGroup cg:condtionGroups)
			{
				evaluate(cg.getConditions(), cg.getConditionGroups(), cg.getLogicalOperator());
				s.append(logicalOpt);
			}
			
			//s.append(logicalOpt);
			decodeConditions(conditions, logicalOpt);
		}
	}

	private static void decodeConditions(List<Condition> conditions, String logicalOpt) 
	{
		int i=0;
		s.append(" ( ");
		for(Condition condition: conditions)
		{
			if(i != 0)
			{
				s.append(" "+logicalOpt);
			}
			
			// Restrictions.eq("status",1);
			s.append(" " + condition.getSearchColumn()  + " " +
						condition.getOperator() + " " + condition.getSearchValue());
			
			i++;
		}
		
		s.append(" ) ");
	}
}
