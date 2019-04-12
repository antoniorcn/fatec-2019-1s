package edu.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {
	List<Observer> lista = new ArrayList<>();
	@Override
	public void add(Observer o) {
		lista.add(o);
	}
	@Override
	public void remove(Observer o) {
		lista.remove(o);
	}
	@Override
	public void notify(Object obj) {
		for (Observer o : lista) { 
			o.update(obj);
		}
	}
}
