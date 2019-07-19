package BookPackage;

public class Aggregate {
	private static final long serialVersionUID = 1L;

	float id;
	float matched;
	float count;
	float min;
	float max;
	String ids;
	
	public String getIds() {
		return ids;
	}



	public void setIds(String ids) {
		this.ids = ids;
	}



	public Aggregate() {
		id=0;
		matched=0;
		count=0;
		ids="";
		max=0;
		min = 0;

	}

	
	
	public float getMin() {
		return min;
	}



	public void setMin(float min) {
		this.min = min;
	}



	public float getMax() {
		return max;
	}



	public void setMax(float max) {
		this.max = max;
	}



	public float getId() {
		return id;
	}



	public void setId(float id) {
		this.id = id;
	}



	public float getMatched() {
		return matched;
	}



	public void setMatched(float matched) {
		this.matched = matched;
	}



	public float getCount() {
		return count;
	}



	public void setCount(float count) {
		this.count = count;
	}



	@Override
	public String toString() {
		return "Aggregate [id=" + id + ", matched=" + matched + ", count=" + count + ", min=" + min + ", max=" + max
				+ ", ids=" + ids + "]";
	}
	
	
}
