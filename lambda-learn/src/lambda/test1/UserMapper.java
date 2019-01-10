package lambda.test1;

/*
 * 指明接口是函数式接口
 * 函数式接口: 只有一个抽象方法的接口
 */
@FunctionalInterface
public interface UserMapper {

	void delete();
	
	int hashCode();	// 继承自 Object, 不算
	
	default int insert() {
		return 1;
	}
	
	static int update() {
		return 1;
	}
	
}
