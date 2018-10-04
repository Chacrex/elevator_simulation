package fr.univ_avignon.m1ilsen.aa.ElevatorSimulator.LogicalView.IHM_Simule.Interface;

public interface IOutdoor {

	abstract void Monter();
	
	abstract void Descendre();
	
	abstract boolean GetEtatPortes();
	
	abstract void SetEtatPortes(boolean b);	
}
