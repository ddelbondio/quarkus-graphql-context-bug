package com.example;

import io.smallrye.graphql.api.Context;
import org.eclipse.microprofile.graphql.*;

@GraphQLApi
public class Api {

	@Query
	@Description("Say hello")
	public Parent1 parent1() {
		Parent1 obj = new Parent1();
		obj.value = "value";
		return obj;
	}

	public Child child(@Source Parent1 parent1, Context context) {
		Child obj = new Child();
		obj.selectedFields = context.getSelectedFields().toString();
		obj.path = context.getPath();
		return obj;
	}

	@Query
	public Parent2 parent2() {
		Parent2 obj = new Parent2();
		obj.parent2Value = "value2";
		return obj;
	}
}
