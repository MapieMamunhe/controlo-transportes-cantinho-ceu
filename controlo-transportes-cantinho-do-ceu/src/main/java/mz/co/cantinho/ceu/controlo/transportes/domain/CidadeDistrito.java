package mz.co.cantinho.ceu.controlo.transportes.domain;

public enum CidadeDistrito {

	//KaMpfumo
	MPT0("Alto Maé A, Distrito de KaMpfumo, Maputo"),
	MPT1("Alto Maé B, Distrito de KaMpfumo, Maputo"),
	MPT2("Central A, Distrito de KaMpfumo, Maputo"),
	MPT3("Central B, Distrito de KaMpfumo, Maputo"),
	MPT4("Central C, Distrito de KaMpfumo, Maputo"),
	MPT5("Coop, Distrito de KaMpfumo, Maputo"),
	MPT6("Malhangalene A, Distrito de KaMpfumo, Maputo"),
	MPT7("Malhangalene B, Distrito de KaMpfumo, Maputo"),
	MPT8("Polana-Cimento A, Distrito de KaMpfumo, Maputo"),
	MPT9("Polana-Cimento B, Distrito de KaMpfumo, Maputo"),
	MPT10("Sommerschield, Distrito de KaMpfumo, Maputo"),
	
	//Nlhamankulo
	MPT11("Bairro do Aeroporto A, Distrito de Nlhamankulo, Maputo"),
	MPT12("Bairro do Aeroporto B, Distrito de Nlhamankulo, Maputo"),
	MPT13("Chamanculo A, Distrito de Nlhamankulo, Maputo"),
	MPT14("Chamanculo B, Distrito de Nlhamankulo, Maputo"),
	MPT15("Chamanculo C, Distrito de Nlhamankulo, Maputo"),
	MPT16("Chamanculo D, Distrito de Nlhamankulo, Maputo"),
	MPT17("Malanga, Distrito de Nlhamankulo, Maputo"),
	MPT18("Minkadjuine, Distrito de Nlhamankulo, Maputo"),
	MPT19("Munhuana, Distrito de Nlhamankulo, Maputo"),
	MPT20("Unidade 7, Distrito de Nlhamankulo, Maputo"),
	MPT21("Xipamanine, Distrito de Nlhamankulo, Maputo"),
	
	//KaMaxakeni
	MPT22("Mafalala, Distrito de KaMaxakeni, Maputo"),
	MPT23("Maxaquene A, Distrito de KaMaxakeni, Maputo"),
	MPT24("Maxaquene B, Distrito de KaMaxakeni, Maputo"),
	MPT25("Maxaquene C, Distrito de KaMaxakeni, Maputo"),
	MPT26("Maxaquene D, Distrito de KaMaxakeni, Maputo"),
	MPT27("Polana Caniço A, Distrito de KaMaxakeni, Maputo"),
	MPT28("Polana Caniço B, Distrito de KaMaxakeni, Maputo"),
	MPT29("Urbanização, Distrito de KaMaxakeni, Maputo"),
	
	//KaMavota
	MPT30("3 de Feverreiro, Distrito de KaMavota, Maputo"),
	MPT31("Albazine, Distrito de KaMavota, Maputo"),
	MPT32("Costa do Sol, Distrito de KaMavota, Maputo"),
	MPT33("FPLM, Distrito de KaMavota, Maputo"),
	MPT34("Ferroviário, Distrito de KaMavota, Maputo"),
	MPT35("Hulene A, Distrito de KaMavota, Maputo"),
	MPT36("Hulene B, Distrito de KaMavota, Maputo"),
	MPT37("Laulane, Distrito de KaMavota, Maputo"),
	MPT38("Mahotas, Distrito de KaMavota, Maputo"),
	MPT39("Mavalane A, Distrito de KaMavota, Maputo"),
	MPT40("Mavalane B, Distrito de KaMavota, Maputo"),
	
	//KaMubukwana
	MPT41("25 de Junho A, Distrito de KaMubukwana, Maputo"),
	MPT42("25 de Junho B, Distrito de KaMubukwana, Maputo"),
	MPT43("Bagamoyo, Distrito de KaMubukwana, Maputo"),
	MPT44("George Dimitrov, Distrito de KaMubukwana, Maputo"),
	MPT45("Ingagóia A, Distrito de KaMubukwana, Maputo"),
	MPT46("Inhagóia B, Distrito de KaMubukwana, Maputo"),
	MPT47("Jardim, Distrito de KaMubukwana, Maputo"),
	MPT48("Luis Cabral, Distrito de KaMubukwana, Maputo"),
	MPT49("Magoanine A, Distrito de KaMubukwana, Maputo"),
	MPT50("Magoanine B, Distrito de KaMubukwana, Maputo"),
	MPT51("Magoanine C, Distrito de KaMubukwana, Maputo"),
	MPT52("Malhazine, Distrito de KaMubukwana, Maputo"),
	MPT53("Nsalene, Distrito de KaMubukwana, Maputo"),
	MPT54("Zimpeto, Distrito de KaMubukwana, Maputo"),
	
	//KaTembe
	MPT55("Inguide, Distrito de KaTembe, Maputo"),
	MPT56("Incassane, Distrito de KaTembe, Maputo"),
	MPT57("Guachene, Distrito de KaTembe, Maputo"),
	MPT58("Chali, Distrito de KaTembe, Maputo"),
	MPT59("Chamissava, Distrito de KaTembe, Maputo"),
	
	//KaNyaka
	MPT60("Ribzwene, Distrito de KaNyaka, Maputo"),
	MPT61("Inguane, Distrito de KaNyaka, Maputo"),
	MPT62("Nhanquene, Distrito de KaNyaka, Maputo"),
	
	MTL("Matola");
	
	private String nome;
	
	CidadeDistrito(String nome){
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
}
