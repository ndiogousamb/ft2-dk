/* global Materialize */

// js/todoList.js
'use strict';

var demoApp = angular.module('ImportExport', [
// Dépendances du "module"
'importexport' ]);

/**
 * Déclaration du module todoList
 */
var todoList = angular.module('importexport', []);

todoList
		.controller(
				'ImportExportController',
				[
						'$scope',
						'$http',
						'$location',
						function($scope, $http, $location) {
							// alert($location.url);
							$scope.idUser = "azerty";
							$scope.verrou = false;
							$scope.CodeProd = "";
							$scope.getListUser = function() {
								$scope.listUser = [];
								$http({
									method : 'GET',
									url : 'listUsers',
									dataType : 'json',

									params : {

									}
								}).success(function(data) {

									$scope.listUser = data;
								});
							};
							  $scope.espececalibre = 'espececalibre';
							   $scope.especeCalibreRbtn = function(){
								
							};
							
							 $scope.moyenTransport = 'camion';
							   $scope.moyenTransportRbtn = function(){
								
							};
							 
							
							
							$scope.getListStock = function() {
								$scope.listStock = [];
								$http({
									method : 'GET',
									url : 'listStock',
									dataType : 'json',

									params : {

									}
								}).success(function(data) {

									$scope.listStock = data;
								});
							};
							
							$scope.getListRole = function() {
								$scope.listRoles = [];
								$http({
									method : 'GET',
									url : 'listRoles',
									dataType : 'json',

									params : {

									}
								}).success(function(data) {
									// alert(data.id);
									$scope.listRoles = data;
								});
							};

							$scope.getListProfil = function() {
								$scope.listProfil = [];
								$http({
									method : 'GET',
									url : 'listProfils',
									dataType : 'json',

									params : {

									}
								}).success(function(data) {
									$scope.listProfil = data;
								});
							};
							/** ******************************* */

							$scope.GetlistCartons = function() {
								$scope.listCartons = [];
								$http({
									method : 'GET',
									url : 'listCartons',
									dataType : 'json',

									params : {

									}
								}).success(function(data) {
									$scope.listCartons = data;
								});
							};
							/** ******************* */
							$scope.GetlistQualites = function() {
								$scope.listQualites = [];
								$http({
									method : 'GET',
									url : 'listQualites',
									dataType : 'json',

									params : {

									}
								}).success(function(data) {
									$scope.listQualites = data;
								});
							};
							/** ************************** */
							$scope.GetlistTunnel = function() {
								$scope.listTunnels = [];
								$http({
									method : 'GET',
									url : 'listTunnel',
									dataType : 'json',

									params : {

									}
								}).success(function(data) {
									$scope.listTunnels = data;
								});
							};

							/** *********************** */
							$scope.listEspeces = function() {
								$scope.listEspeces = [];
								$http({
									method : 'GET',
									url : 'listEspeces',
									dataType : 'json',

									params : {

									}
								}).success(function(data) {
									$scope.listEspeces = data;
								});
							};

							$scope.listCalibres = function() {
								$scope.listCalibres = [];
								$http({
									method : 'GET',
									url : 'listCalibres',
									dataType : 'json',

									params : {

									}
								}).success(function(data) {
									$scope.listCalibres = data;
								});
							};
						
							/** ****************************** */
							$scope.elements=[];
							$scope.add = function(element) {

// if ($scope.item.calibre == undefined
// || $scope.item.espece == undefined
// || $scope.item.poids == undefined) {
// sweetAlert("Erreur",
// "Remplissez tous les champs!",
// "error");
// return;
// }

// else if ($scope.item.poids <= 0) {
// sweetAlert("Erreur",
// "Poids Saisi est incorrect!",
// "error");
// return;
// } else {
							if ($scope.element.calibre == undefined)
								   $scope.element.calibre="GROS POISSON";
							else{ 
								if($scope.element.typecarton!=undefined)
									{
									if($scope.element.typecarton=="14 KG")
										$scope.element.poids=14*$scope.element.nbCarton;
									
								else if($scope.element.typecarton=="20 KG")
									$scope.element.poids=20*$scope.element.nbCarton;
								else if($scope.element.typecarton=="28 KG")
									$scope.element.poids=28*$scope.element.nbCarton;
									}
									$scope.elements.push(element);
									$scope.element = {};
							}s
								// }

							},
							
							
							
							/** ***************************** */

							$scope.items = [];
							$scope.addItem = function(item) {

								if ($scope.item.calibre == undefined
										|| $scope.item.espece == undefined
										|| $scope.item.poids == undefined) {
									sweetAlert("Erreur",
											"Remplissez tous les champs!",
											"error");
									return;
								}

								else if ($scope.item.poids <= 0) {
									sweetAlert("Erreur",
											"Poids Saisi est incorrect!",
											"error");
									return;
								} else {
									$scope.items.push(item);
									$scope.item = {};
								}

							},
							
							
							$scope.UpdateItem = function(item) {
								if ($scope.item.calibre == undefined
										|| $scope.item.espece == undefined
										|| $scope.item.poids == undefined) {
									sweetAlert("Erreur",
											"Remplissez tous les champs!",
											"error");
									return;
								} else if ($scope.item.poids <= 0) {
									sweetAlert("Erreur",
											"Poids Saisi est incorrect!",
											"error");
									return;
// } else {
// var index = $scope.items.indexOf(item);
// // var index = $scope.items.findIndex(item);
// alert(index);
// // findIndex
// alert($scope.item.poids+" "+($scope.item.espece)+" "+($scope.item.calibre));
//									
// $scope.remove(item);
// // $scope.items[index]=item;
// $scope.addItem(item);
// // alert(item.poids);
// $scope.item = {};
// $('#ModalUpdate').modal('hide');
// sweetAlert("OK", "Modification reussi",
// "success");
									for (var i = 0; i < $scope.items.length; i++) {
										var p = $scope.listEspecesProduites[i];
										if (p==item)
											p=item;
									}

									return;
								}

							}
							$scope.remove = function(item) {

								var index = $scope.items.indexOf(item);
								// alert(index);
								$scope.items.splice(index, 1);
							};

							/** *********************************** */
							$scope.saveProduction = function() {

								var Debdate = $('#SamaDateDeb').val();
								var Findate = $('#SamaDateFin').val();

								if ($scope.items.length < 1) {
									sweetAlert("Erreur",
											"Veuillez choisir vos especes!",
											"error");
									return;
								}

								else if ($scope.PrenomMarayeur == undefined
										|| $scope.NomMarayeur == undefined
										|| $scope.Immatricule == undefined
										|| $scope.CIN == undefined
										|| Debdate == "" || Findate == "") {
									sweetAlert("Erreur",
											"Remplissez tous les champs!",
											"error");
									return;
								} else if ($scope.Immatricule.length < 7) {
									sweetAlert(
											"Erreur",
											"Numero Immatriculation incorrect!",
											"error");
									return;
								} else if ($scope.CIN.length < 13) {
									sweetAlert("Erreur", "Numero CIN!", "error");
									return;
								} else {

									$http(
											{
												method : 'GET',
												url : 'saveProduction',
												dataType : 'json',
												params : {
													PrenomMarayeur : $scope.PrenomMarayeur,
													NomMarayeur : $scope.NomMarayeur,
													Immatricule : $scope.Immatricule,
													Debdate : Debdate,
													Findate : Findate,
													CIN : $scope.CIN,
													items : $scope.items
												}
											})
											.then(
													function(response) {
														if (response.data.id != null) {
															sweetAlert(
																	"Production Enregistre!",
																	"Preparez vous a entammez le Demoullage!",
																	"success");
																	$scope.PrenomMarayeur = undefined;
																	$scope.NomMarayeur = undefined;
																	$scope.Immatricule = undefined;
																	$scope.CIN == undefined;
																	Debdate = undefined;
																	Findate = undefined;
																	$scope.items = {};
//															window.location
//																	.reload();
//																	listCalibres();
//																	listEspeces();

														}

													});
								}
							};
							
							/** ****************************** */
							
							
							$scope.saveDebarquement = function() {
									alert("ok");
								var DateDebarquement = $('#DateDebarquement').val();
								

								if ($scope.elements.length < 1) {
									sweetAlert("Erreur",
											"Veuillez ajouter une espece au moins!",
											"error");
									return;
								}

								else if ($scope.Navire == undefined
										|| $scope.PrenomFournisseur == undefined
										|| $scope.NomFournisseur == undefined
										|| $scope.Manifeste == undefined
										|| DateDebarquement == "" ) {
									sweetAlert("Erreur",
											"Remplissez tous les champs!",
											"error");
									return;
								} 
								else {
										alert("2e ok");
										alert($scope.Navire);
										alert($scope.Manifeste);
										alert($scope.PrenomFournisseur);
										alert($scope.NomFournisseur);
										alert(DateDebarquement);
										for (var i = 0; i < $scope.elements.length; i++) {
											var p = $scope.elements[i];
											alert(p.espece);
											alert(p.calibre);
											alert(p.poids);
											alert(p.nbCarton);
											alert(p.qualite);
											alert(p.Destination);
											alert(p.NbTransporter);
											
										}
										
									$http(
											{
												method : 'GET',
												url : 'save',
												dataType : 'json',
												params : {
													Navire : $scope.Navire,
													Manifeste : $scope.Manifeste,
													PrenomFournisseur : $scope.PrenomFournisseur,
													NomFournisseur : $scope.NomFournisseur,
													DateDebarq : DateDebarquement,
													lesElements : $scope.elements
												}
											})
											.then(
													function(response) {
														if (response.data.id != null) {
															sweetAlert(
																	"Debarquement Enregistre!",
																	"",
																	"success");
																	$scope.Navire = "",
																	$scope.PrenomFournisseur = "",
																	$scope.NomFournisseur = "",
																	NomFournisseur = "",
																	$scope.elements = {};
															window.location
																	.reload();

														}

													});
								}
							};
							
							
							
							
							
							
							
							/** ************************** */
							$scope.Mytesteur="";
							$scope.SaveDemoulageEspecesCalibrees = function() {
								
								var id=$scope.idEspeceDemoulee;
								
								
								 if ($scope.espece == undefined
										|| $scope.calibre == undefined
										|| $scope.typecarton == undefined
										|| $scope.qualite == undefined
										|| $scope.tunnel == undefined
										|| $scope.qualite == undefined) {
									sweetAlert("Erreur",
											"Remplissez tous les champs!",
											"error");
									return;
									
								} else if ($scope.poids<=0) {
									sweetAlert(
											"Erreur",
											"Le Poids saisi est incorrect!",
											"error");
									return;
								} else if ($scope.nbCarton<=0) {
									sweetAlert(
											"Erreur",
											"Le Nombre de Carton saisi est incorrect!",
											"error");
									return;
								} else {
										
									$http(
											
											{
												method : 'GET',
												url : 'saveDemoulage',
												dataType : 'json',
												params : {
													espece : $scope.espece,
													calibre : $scope.calibre,
													poids : $scope.poids,
													typecarton : $scope.typecarton,
													nbCarton : $scope.nbCarton,
													qualite : $scope.qualite,
													tunnel : $scope.tunnel,
													id 
												}
											})
											.then(
													function(response) {
														if (response.data.id != null) {
															sweetAlert(
																	"Espece Enregistree!",
																	"Enregistrement reussi!",
																	"success");
															$scope.getProductionByCodeProduction();
															$scope.nbCarton="";
															$scope.tunnel="";
															$scope.qualite="";
															$scope.typecarton="";
															$scope.Mytesteur=1;
															
														}
														

													});
								}
							};
							
							
							
							
							/** ********************************** */

							$scope.listTousLesProduction = function() {

								$scope.listProduction = [];
								$http({
									method : 'GET',
									url : 'listTousLesProduction',
									dataType : 'json',

									params : {}
								}).success(function(data) {
									$scope.listProduction = data;
									if($scope.listProduction.length<=0){
										sweetAlert(
												"Erreur",
												"Aucune Production disponible!",
												"error");
									}
							
								});
							};
							
							
							$scope.getListProduction = function() {

								$scope.listProduction = [];
								$http({
									method : 'GET',
									url : 'listProduction',
									dataType : 'json',

									params : {}
								}).success(function(data) {
									$scope.listProduction = data;
									if($scope.listProduction.length<=0){
										sweetAlert(
												"Erreur",
												"Aucune Production a regler en Attente!",
												"error");
									}
							
								});
							};
							
							
							
							
							$scope.getListProductionAll = function() {

								$scope.listProduction = [];
								$http({
									method : 'GET',
									url : 'listProductionAll',
									dataType : 'json',

									params : {}
								}).success(function(data) {
									$scope.listProduction = data;
								});
							};
							
							
							$scope.getListProductionNonDemoule = function() {

								$scope.listProduction = [];
								$http({
									method : 'GET',
									url : 'listProduction',
									dataType : 'json',

									params : {}
								}).success(function(data) {
									$scope.listProduction = data;
									if($scope.listProduction.length<=0){
										sweetAlert(
												"Erreur",
												"Aucun Demoulage en Attente!",
												"error");
									}
								});
							};
							
							/** ******************************** */
							$scope.getListProductionRegle = function() {
									
								$scope.listProduction = [];
								$http({
									method : 'GET',
									url : 'listProductionRegle',
									dataType : 'json',

									params : {}
								}).success(function(data) {
									$scope.listProduction = data;
								});
							};

							/** **************************** */
							
							
// $scope.getPoidsTotal = function() {
// var total = 0;
//								
// $scope.;
//									
// total = total
// + parseInt(p.prixunitaire);
// else
// total = total
// + parseInt(p.plaignat
// * p.prixunitaire);
//
// }
// if (isNaN(total)) {
// total = 0;
// return total;
								
								// return parseInt(total);
							// };
							
							
							
							
							
							
							
							/** ************************ */
							$scope.getTotal = function() {
								var total = 0;
								for (var i = 0; i < $scope.listEspecesProduites.length; i++) {
									var p = $scope.listEspecesProduites[i];
									if (p.calibre.libelleCalibre === 'GROS POISSON')
										total = total
												+ parseInt(p.prixunitaire);
									else
										total = total
												+ parseInt(p.plaignat
														* p.prixunitaire);

								}
								if (isNaN(total)) {
									total = 0;
									return total;
								}
								return parseInt(total);
							};
							/** ************************** */
							$scope.CalculNbCarton = function() {
							if ($scope.typecarton==1)
								$scope.nbCarton=parseInt($scope.poids/14);
							else if($scope.typecarton==2)
								 $scope.nbCarton=parseInt($scope.poids/20);
							else if ($scope.typecarton==3)
								$scope.nbCarton=parseInt($scope.poids/28);
							$scope.nbCarton=parseInt($scope.poids/tc);
							if($scope.poids <14)
								sweetAlert("Erreur",
										"Poids Anormal!",
										"error");
								return;
							};
							
							$scope.ImprimerFactureProduction = function() {
							
								$http(
										{
											method : 'GET',
											url : 'ImprimerFactureProduction',
											dataType : 'json',
											params : {
												Code : window.location.href
												.split("?")[1]
											}
										})
										
										
							};
							/** ************************* */

							$scope.saveFactureProduction = function() {
								for (var i = 0; i < $scope.listEspecesProduites.length; i++) {
									if ($scope.listEspecesProduites[i].montant === undefined
											|| isNaN($scope.listEspecesProduites[i].montant)
											|| $scope.listEspecesProduites[i].montant <= 0
											|| isNaN($scope.listEspecesProduites[i].montant)) {
										sweetAlert("Erreur",
												"Remplissez tous les champs!",
												"error");
										return;
									}
								}
								$http(
										{
											method : 'GET',
											url : 'saveFactureProduction',
											dataType : 'json',
											params : {
												listespeces : $scope.listEspecesProduites
											}
										})
										.then(
												function(response) {
													if (response.data.id != null) {
														sweetAlert(
																"Facturation Reussi!",
																" Veuillez patienter pour l'impression de la Facture!",
																"success");
														$scope.listEspecesProduites = {};

													}
												});
							};

							/** ***************************** */
							
							$scope.EspeceProduiteByCodeNonRegle = function() {
								var Code = window.location.href.split("?")[1];
								$scope.listEspecesProduites = [];
								$http(
										{
											method : 'GET',
											url : 'EspeceProduiteByCodeNonRegle',
											dataType : 'json',

											params : {
												Code : window.location.href
														.split("?")[1]
											}
										}).success(function(data) {
									$scope.listEspecesProduites = data;
									if($scope.listEspecesProduites.length<=0){
										sweetAlert(
												"Erreur",
												"Production deja Facture!",
												"error");
									}
								});

							};
							$scope.EspeceProduiteByCode = function() {
							
								var Code = window.location.href.split("?")[1];
								$scope.listEspecesProduites = [];
								$http(
										{
											method : 'GET',
											url : 'EspeceProduiteByCodeProduction',
											dataType : 'json',

											params : {
												Code : window.location.href
														.split("?")[1]
											}
										}).success(function(data) {
									$scope.listEspecesProduites = data;
								});

							};
							
							
							
							
							/** ****************** */
							$scope.getProductionByCodeProduction = function() {
								// var Code =
								// window.location.href.split("?")[1];
								
								$scope.listEspecesProduites = [];
								$http(
										{
											method : 'GET',
											url : 'ListEspeceProduiteNonDemoule',
											dataType : 'json',

											params : {
												
											}
										}).success(function(data) {
									$scope.listEspecesProduites = data;
									
									if($scope.listEspecesProduites.length<=0 && $scope.Mytesteur!=1){
										sweetAlert(
												"Erreur",
												" Aucune Espece a Demouler !",
												"error");
									}
									

								});

							};
							
							$scope.getEspeceProduiteByCodePourFacturation = function() {
								var Code = window.location.href.split("?")[1];
								$scope.listEspecesProduites = [];
								$http(
										{
											method : 'GET',
											url : 'EspeceProduiteReglePourFacturation',
											dataType : 'json',

											params : {
												Code : window.location.href
														.split("?")[1]
											}
										}).success(function(data) {

									$scope.listEspecesProduites = data;
									

								});

							};
							
							
							$scope.getEspeceProduiteByCode = function() {
								var Code = window.location.href.split("?")[1];
								// alert(Code);
								$scope.listEspecesProduites = [];
								$http(
										{
											method : 'GET',
											url : 'EspeceProduite',
											dataType : 'json',

											params : {
												Code : window.location.href
														.split("?")[1]
											}
										}).success(function(data) {

									$scope.listEspecesProduites = data;
								

								});

							};
							
							
							
							$scope.getEspeceProduiteByCodePourModification = function() {
								var Code = window.location.href.split("?")[1];
								$scope.listEspecesProduites = [];
								$http(
										{
											method : 'GET',
											url : 'EspeceProduite',
											dataType : 'json',

											params : {
												Code : window.location.href
														.split("?")[1]
											}
										}).success(function(data) {

									$scope.listEspecesProduites = data;
									$scope.Datedeb=$scope.listEspecesProduites[0].production.dateDebut;
									$scope.Datefin=$scope.listEspecesProduites[0].production.dateFin;
									$scope.CIN=$scope.listEspecesProduites[0].production.marayeur.cinMarayeur;
									$scope.PrenomMarayeur=$scope.listEspecesProduites[0].production.marayeur.prenomMarayeur;
									$scope.NomMarayeur=$scope.listEspecesProduites[0].production.marayeur.nomMarayeur;
									$scope.Immatricule=$scope.listEspecesProduites[0].production.vehicule.numImmatriculation;
									$scope.CodeProduction=$scope.listEspecesProduites[0].production.codeProduction;
									

								});

							};
							

							/** ****************************** */

							$scope.LoadDataForPanierProduction = function() {
								// var index = $scope.items.indexOf(item);
								// alert(index);
								$scope.item.espece = this.item.espece;
								$scope.item.calibre = this.item.calibre;
								$scope.item.poids = this.item.poids;

							};
							$scope.LoadDataEspece = function() {

								$scope.CodeProduction = this.e.production.codeProduction;
								$scope.espece = this.espece.libelleEspece;
								$scope.calibre = this.e.calibre.libelleCalibre;
								$scope.poids = this.e.poids;

							};
							$scope.idEspeceDemoulee="";
							$scope.LoadDataEspecePourDemoulage = function() {
								$scope.verrou = true;
								$scope.espece = this.e.espece.libelleEspece;
								$scope.calibre = this.e.calibre.libelleCalibre;
								$scope.poids = this.e.poids;
								$scope.idEspeceDemoulee=this.e.id;
							};
							
							$scope.idEspeceProduite="";
							$scope.LoadDataPourModif = function() {
								$scope.espece = this.e.espece.libelleEspece;
								$scope.calibre = this.e.calibre.libelleCalibre;
								$scope.poids = this.e.plaignat;
								$scope.idEspeceProduite=this.e.id;
							};
							
							$scope.loadData = function() {
								$scope.idUser = this.l.id;
								$scope.nomComplet = this.l.nomComplet;
								$scope.login = this.l.login;
								$scope.role = this.l.role.role;
								$scope.profil = this.l.profil.nomProfil;
								$scope.idprofil = this.l.profil.id;

							};

							$scope.validerInscription = function() {

								if ($scope.password == ""
										|| $scope.Confpassword == ""
										|| $scope.nomComplet == ""
										|| $scope.login === ""
										|| $scope.profil == ""
										|| $scope.role == "") {
									sweetAlert(
											"Erreur",
											"Remplissez tous les champs afin de vous inscrire!",
											"error");
								} else if ($scope.password.length < 5) {
									sweetAlert(
											"Erreur",
											"Le mot de passe est trop court! 6 caracteres minimum",
											"error");

								}

								else if ($scope.password !== $scope.Confpassword) {
									sweetAlert(
											"Erreur",
											"Les mots de passes ne correspondent pas.Merci de reesseyer!",
											"error");

								} else {

									$http({
										method : 'GET',
										url : 'addUser',
										dataType : 'json',

										params : {
											nomComplet : $scope.nomComplet,
											login : $scope.login,
											password : $scope.password,
											profil : $scope.profil,
											role : $scope.role
										}
									})
											.then(
													function(response) {
														if (response.data.id != null) {
															sweetAlert(
																	"Inscription reussie!",
																	"L'Administrateur procedera a l'activation du compte!",
																	"success");
															$scope.nomComplet = "";
															$scope.login = "";
															$scope.password = "";
															$scope.Confpassword = "";
															$scope.role = "";
															$scope.profil = "";

														}
													});
								}

							};

							/* Activer user */

							$scope.activerUtilisateur = function() {

								$http({
									method : 'GET',
									url : 'activerUser',
									dataType : 'json',
									params : {
										nomComplet : $scope.nomComplet,
										login : $scope.login,
										profil : $scope.profil,
										role : $scope.role,
										idUser : $scope.idUser
									}
								})
										.then(
												function(response) {
													if (response.data.id != null) {
														// $('#ModalActivation').modal('hide');
														sweetAlert(
																"Compte Activé!",
																"Le compte est maintenant fonctionnel!",
																"success");
														$scope.nomComplet = "";
														$scope.login = "";
														$scope.role = "";
														$scope.profil = "";
														$scope.getListUser();
														$('#ModalActivation')
																.modal('hide');
														// $modalInstance.close();

													}

												});

							};
							/** *************** */

							/* Desactiver user */

							$scope.desactiverUtilisateur = function() {

								$http({
									method : 'GET',
									url : 'desactiverUser',
									dataType : 'json',

									params : {

										idUser : $scope.idUser
									}

								})
										.then(
												function(response) {

													if (response.data.id != null) {
														sweetAlert(
																"Compte desactivé!",
																"Le compte n'est plus fonctionnel!",
																"success");
														$scope.login = "";
														$scope.getListUser();
														$('#ModalDesactivation')
																.modal('hide');
													}

												});

							};
							/** *************** */
							/* Update user */

							$scope.modifierUtilisateur = function() {

								$http({
									method : 'GET',
									url : 'UpdateUser',
									dataType : 'json',

									params : {
										nomComplet : $scope.nomComplet,
										login : $scope.login,
										profil : $scope.profil,
										role : $scope.role,
										idUser : $scope.idUser

									}

								})
										.then(
												function(response) {

													if (response.data.id != null) {
														sweetAlert(
																"Modification reussie!",
																"", "success");
														$scope.nomComplet = "";
														$scope.login = "";
														$scope.role = "";
														$scope.profil = "";
														$scope.getListUser();
														$('#ModalUpdate')
																.modal('hide');

													}

												});

							};
							
							$scope.modifierEspeceProduite = function() {
								
								$http({
									method : 'GET',
									url : 'UpdateEspeceProduite',
									dataType : 'json',
									params : {
										calibre : $scope.calibre,
										espece : $scope.espece,
										poids : $scope.poids,
										idEspeceProduite : $scope.idEspeceProduite
									}

								})
										.then(
												function(response) {

													if (response.data.id != null) {
														sweetAlert(
																"Modification reussie!",
																"", "success");
														$scope.getEspeceProduiteByCodePourModification();
														
														$('#ModalUpdate')
																.modal('hide');

													}

												});

							};
							
							/** *************** */

							/* Delete user */

							$scope.supprimerUtilisateur = function() {

								$http({
									method : 'GET',
									url : 'deleteUser',
									dataType : 'json',

									params : {

										idUser : $scope.idUser

									}

								})
										.then(
												function(response) {

													if (response.data.id != null) {
														$scope.nomComplet = "";
														$scope.login = "";
														sweetAlert(
																"Suppression reussie!",
																"", "success");

														$scope.getListUser();
														$('#ModalDelete')
																.modal('hide');

													}

												});

							};
							/** *************** */

							$scope.error = function() {
								sweetAlert(
										"Erreur",
										"Identifiant ou mot de passe incorrect!",
										"error");
							};

							/** *********************************** */

							$scope.verifierLogin = function() {

								$http({
									method : 'GET',
									url : 'verifierLogin',
									dataType : 'json',

									params : {

										login : $scope.login
									}

								})
										.then(
												function(response) {
													if (response.data.id !== 0) {
														$scope.verrou = true;
														sweetAlert(
																"Erreur",
																"Identifiant deja utilisé.Choisissez un autre!",
																"error");

													} else {
														$scope.verrou = false;
													}

												});

							};
							
							$scope.UpdateProduction = function() {

								var Debdate = $('#SamaDateDeb').val();
								var Findate = $('#SamaDateFin').val();

								 if ($scope.PrenomMarayeur == undefined
										|| $scope.NomMarayeur == undefined
										|| $scope.Immatricule == undefined
										|| $scope.CIN == undefined
										|| $scope.CodeProduction == undefined
										|| Debdate == "" || Findate == "") {
									sweetAlert("Erreur",
											"Remplissez tous les champs!",
											"error");
									return;
								} else if ($scope.Immatricule.length < 7) {
									sweetAlert(
											"Erreur",
											"Numero Immatriculation incorrect!",
											"error");
									return;
								} else if ($scope.CIN.length < 13) {
									sweetAlert("Erreur", "Numero CIN!", "error");
									return;
								} else {

									$http(
											{
												method : 'GET',
												url : 'UpdateProduction',
												dataType : 'json',
												params : {
													PrenomMarayeur : $scope.PrenomMarayeur,
													NomMarayeur : $scope.NomMarayeur,
													Immatricule : $scope.Immatricule,
													Debdate : Debdate,
													Findate : Findate,
													CIN : $scope.CIN,
													CodeProduction:$scope.CodeProduction,
													Code : window.location.href
													.split("?")[1]
												}
											})
											.then(
													function(response) {
														if (response.data.id != null) {
															sweetAlert(
																	"Modification reussie!",
																	"Production Modifiee!",
																	"success");
																	$scope.PrenomMarayeur = undefined;
																	$scope.NomMarayeur = undefined;
																	$scope.Immatricule = undefined;
																	$scope.CIN == undefined;
																	Debdate = undefined;
																	Findate = undefined;
																	$scope.items = {};
//															window.location
//																	.reload();
//																	listCalibres();
//																	listEspeces();

														}

													});
								}
							};

							/** ****************************** */
							$scope.verifierCIN = function() {

								$http({
									method : 'GET',
									url : 'verifierCIN',
									dataType : 'json',

									params : {

										CIN : $scope.CIN
									}

								})
										.then(
												function(response) {
													if (response.data.id !== 0) {
														var nom = response.data.nomMarayeur;
														var prenom = response.data.prenomMarayeur;
														$scope.NomMarayeur = nom;
														$scope.PrenomMarayeur = prenom;
														$scope.verrou = true;
													} else {
														$scope.verrou = false;
													}

												});

							};

							/** ******************************** */
							$scope.ChargerCode = function() {
								
								var testeur = 0;
								
								testeur = this.p.id;
								
							};

							/** ******************************* */
						}

				]);
