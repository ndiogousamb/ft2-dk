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
						'$log',
						function($scope, $http, $location, $log) {

							$scope.saveDebarquement = function() {

								var DateDebarquement = $('#DateDebarquement')
										.val();

								if ($scope.elements.length < 1) {
									sweetAlert(
											"Erreur",
											"Veuillez ajouter une espece au moins!",
											"error");
									return;
								}

								else if ($scope.Navire == undefined
										|| $scope.PrenomFournisseur == undefined
										|| $scope.NomFournisseur == undefined
										|| $scope.Manifeste == undefined
										|| DateDebarquement == "") {
									sweetAlert("Erreur",
											"Remplissez tous les champs!",
											"error");
									return;
								} else {

									$http(

											{

												method : 'GET',
												url : 'saveDebarquement',
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
																	$scope.Manifeste = "",
																	$scope.elements = {};
															// window.location
															// .reload();

														}

													});
								}
							};

							$scope.idEspeceAchete = "";
							$scope.LoadDataPourModifVenteLocale = function() {
								$scope.espece = this.e.especeDemoulee.espece.libelleEspece;
								$scope.calibre = this.e.especeDemoulee.calibre.libelleCalibre;
								$scope.typecarton = this.e.especeDemoulee.typeCarton.libelleTypecarton;
								$scope.nbCarton = this.e.nombreCartonAchete;
								$scope.poids = this.e.poids;
								$scope.idEspeceAchete = this.e.id;
							};
							
							$scope.idEspeceAchete = "";
							$scope.LoadDataPourModifVenteLocaleGrosPoisson = function() {
								$scope.espece = this.e.especeDemoulee.espece.libelleEspece;
								$scope.poids = this.e.poids;
								$scope.idEspeceAchete = this.e.id;
							};

							$scope.modifierEspeceAchetes = function() {
									
								$http(
										{
											method : 'GET',
											url : 'UpdateEspeceAchetees',
											dataType : 'json',
											params : {
												calibre : $scope.calibre,
												espece : $scope.espece,
												typecarton : $scope.typecarton,
												nbCarton : $scope.nbCarton,
												idEspeceAchete : $scope.idEspeceAchete
											}

										})
										.then(
												function(response) {

													if (response.data.id != null) {
														sweetAlert(
																"Modification reussie!",
																"", "success");
														$scope
																.EspeceDemoulee_VenteLocalePourModification();

														$('#ModalUpdate')
																.modal('hide');

													}

												});

							};

							$scope.saveVenteLocale = function() {
								var DateAchat = $('#DateAchat').val();
								if ($scope.elements.length < 1) {
									sweetAlert(
											"Erreur",
											"Veuillez ajouter une espece au moins!",
											"error");
									return;
								} else if ($scope.NomClient == undefined
										|| $scope.PrenomClient == undefined
										|| DateAchat == "") {
									sweetAlert("Erreur",
											"Remplissez tous les champs!",
											"error");
									return;
								} else {

									$http(

									{

										method : 'GET',
										url : 'saveVenteLocale',
										dataType : 'json',
										params : {
											PrenomClient : $scope.PrenomClient,
											NomClient : $scope.NomClient,
											DateAchat : DateAchat,
											lesElements : $scope.elements
										}
									})
											.then(
													function(response) {
														if (response.data.id != null) {
															sweetAlert(
																	"Vente Locale Enregistree!",
																	"",
																	"success");
																	$scope.Navire = "",
																	$scope.PrenomFournisseur = "",
																	$scope.NomFournisseur = "",
																	$scope.Manifeste = "",
																	$scope.elements = {};
															// window.location
															// .reload();

														}

													});
								}
							};
							$scope.saveExportation = function() {
								var DateExportation = $('#DateExportation')
										.val();
								if ($scope.Expelements.length < 1) {
									sweetAlert(
											"Erreur",
											"Veuillez ajouter une espece au moins!",
											"error");
									return;
								} else if ($scope.PrenomDestinataire == undefined
										|| $scope.NomDestinataire == undefined
										|| $scope.paysDestination == undefined
										|| $scope.ChargeurExportation == undefined
										|| $scope.paysOrigine == undefined
										|| $scope.AdresseDestinataire == undefined
										|| DateExportation == "") {
									sweetAlert("Erreur",
											"Remplissez tous les champs!",
											"error");
									return;
								} else {
									$http(
											{
												method : 'GET',
												url : 'saveExportation',
												dataType : 'json',
												params : {
													PrenomDestinataire : $scope.PrenomDestinataire,
													NomDestinataire : $scope.NomDestinataire,
													paysDestination : $scope.paysDestination,
													ChargeurExportation : $scope.ChargeurExportation,
													paysOrigine : $scope.paysOrigine,
													DateExportation : DateExportation,
													AdresseDestinataire : $scope.AdresseDestinataire,
													lesElementsExp : $scope.Expelements
												}
											})
											.then(
													function(response) {
														if (response.data.id != null) {
															sweetAlert(
																	"Exportation enregistree!",
																	"",
																	"success");
																	$scope.PrenomDestinataire = undefined,
																	$scope.NomDestinataire = undefined,
																	$scope.paysDestination = undefined,
																	$scope.ChargeurExportation = undefined,
																	$scope.paysOrigine = undefined,
																	$scope.Expelements = {};
															// window.location
															// .reload();

														}

													});
								}
							};
							$scope.remove = function(element) {
								var index = $scope.elements.indexOf(element);
								// alert(index);
								$scope.elements.splice(index, 1);
							};
							$scope.removeExp = function(Expelement) {
								var index = $scope.Expelements
										.indexOf(Expelement);
								$scope.Expelements.splice(index, 1);
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

							$scope.listTypeContainer = function() {
								$scope.listTypeContainers = [];
								$http({
									method : 'GET',
									url : 'listTypeContainer',
									dataType : 'json'
								}).success(function(data) {
									$scope.listTypeContainers = data;
								});
							};

							$scope.getListDebarquement = function() {

								$scope.listDebarquement = [];
								$http({
									method : 'GET',
									url : 'listDebarquement',
									dataType : 'json',

									params : {}
								})
										.success(
												function(data) {
													$scope.listDebarquement = data;
													if ($scope.listDebarquement.length <= 0) {
														sweetAlert(
																"Erreur",
																"Aucun Debarquement a regler en Attente!",
																"error");
													}

												});
							};

							$scope.getListVenteLocaleAFacturer = function() {

								$scope.listVenteLocale = [];
								$http({
									method : 'GET',
									url : 'listVenteLocaleAFacturer',
									dataType : 'json',

									params : {}
								})
										.success(
												function(data) {
													$scope.listVenteLocale = data;
													if ($scope.listVenteLocale.length <= 0) {
														sweetAlert(
																"Erreur",
																"Aucune Vente Locale a regler en Attente!",
																"error");
													}

												});
							};

							$scope.getListExportationAFacturer = function() {
								$scope.listExportation = [];
								$http({
									method : 'GET',
									url : 'listExportationAFacturer',
									dataType : 'json',

									params : {}
								})
										.success(
												function(data) {
													$scope.listExportation = data;
													if ($scope.listExportation.length <= 0) {
														sweetAlert(
																"Erreur",
																"Aucune Exportation a regler en Attente!",
																"error");
													}

												});
							};

							$scope.getListExportationDejaFacture = function() {
								$scope.listExportation = [];
								$http({
									method : 'GET',
									url : 'listExportationDejaFacture',
									dataType : 'json',

									params : {}
								})
										.success(
												function(data) {
													$scope.listExportation = data;
													if ($scope.listExportation.length <= 0) {
														sweetAlert(
																"Erreur",
																"Aucune Exportation Disponible!",
																"error");
													}

												});
							};

							$scope.getListExportationAConsulter = function() {

								$scope.listExportation = [];
								$http({
									method : 'GET',
									url : 'getListExportationAConsulter',
									dataType : 'json',

									params : {}
								})
										.success(
												function(data) {
													$scope.listExportation = data;
													if ($scope.listExportation.length <= 0) {
														sweetAlert(
																"Erreur",
																"Aucune Exportation a regler en Attente!",
																"error");
													}

												});
							};

							$scope.getListVenteLocaleDejaFacture = function() {

								$scope.listVenteLocale = [];
								$http({
									method : 'GET',
									url : 'listVenteLocaleADejaFacture',
									dataType : 'json',

									params : {}
								})
										.success(
												function(data) {
													$scope.listVenteLocale = data;
													if ($scope.listVenteLocale.length <= 0) {
														sweetAlert(
																"Erreur",
																"Aucune Vente Locale a regler en Attente!",
																"error");
													}

												});
							};

							$scope.getListTousLesVenteLocales = function() {

								$scope.listVenteLocale = [];
								$http({
									method : 'GET',
									url : 'listTousLesVenteLocales',
									dataType : 'json',

									params : {}
								})
										.success(
												function(data) {
													$scope.listVenteLocale = data;
													if ($scope.listVenteLocale.length <= 0) {
														sweetAlert(
																"Erreur",
																"Aucune Vente Locale disponible!",
																"error");
													}

												});
							};

							$scope.getListTousLesDebarquement = function() {

								$scope.listDebarquement = [];
								$http({
									method : 'GET',
									url : 'listTousLesDebarquement',
									dataType : 'json',

									params : {}
								})
										.success(
												function(data) {
													$scope.listDebarquement = data;
													if ($scope.listDebarquement.length <= 0) {
														sweetAlert(
																"Erreur",
																"Aucune Debarquement a regler en Attente!",
																"error");
													} else {

														$scope.viewby = 10;
														$scope.totalItems = $scope.listDebarquement.length;
														$scope.currentPage = 1;
														$scope.itemsPerPage = $scope.viewby;
														$scope.maxSize = 5; // Number
														// of
														// pager
														// buttons
														// to
														// show

														$scope.setPage = function(
																pageNo) {
															$scope.currentPage = pageNo;
														};

														$scope.pageChanged = function() {
															console
																	.log('Page changed to: '
																			+ $scope.currentPage);
														};

														$scope.setItemsPerPage = function(
																num) {
															$scope.itemsPerPage = num;
															$scope.currentPage = 1; // reset
															// to
															// first
															// page
														}
													}

												});
							};

							$scope.verifierNavire = function() {

								$http({
									method : 'GET',
									url : 'verifierNavire',
									dataType : 'json',

									params : {

										Navire : $scope.Navire
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
							$scope.changement = function() {
								$scope.element.calibre = undefined;
								$scope.element.qualite = undefined;
								$scope.element.typecarton = undefined;
								$scope.soldeActuel = 0;
								$scope.idStock = 0;
							}
							$scope.changementExportation = function() {
								$scope.Expelement.calibre = undefined;
								$scope.Expelement.qualite = undefined;
								$scope.Expelement.typecarton = undefined;
								$scope.ExpsoldeActuel = 0;
								$scope.ExpidStock = 0;
							}
							$scope.VerifierDispoStock = function() {
								if ($scope.element.nbCarton == undefined) {
									sweetAlert("Erreur",
											"Veuillez saisir un nombre!",
											"error");
									$scope.element.nbCarton = undefined;
									return;
								}
								if ($scope.soldeActuel < $scope.element.nbCarton) {
									sweetAlert(
											"Erreur",
											"Le nombre de cartons saisi est superieur au solde disponible!",
											"error");
									$scope.element.nbCarton = $scope.soldeActuel;
									return;
								}
							};
							$scope.VerifierDispoStockExp = function() {
								if ($scope.Expelement.nbCarton == undefined) {
									sweetAlert("Erreur",
											"Veuillez saisir un nombre!",
											"error");
									$scope.Expelement.nbCarton = undefined;
									$scope.ExpidStock = 0;
									return;
								}
								if ($scope.ExpsoldeActuel < $scope.Expelement.nbCarton) {
									sweetAlert(
											"Erreur",
											"Le nombre de cartons saisi est superieur au solde disponible!",
											"error");
									$scope.Expelement.nbCarton = $scope.ExpsoldeActuel;
									return;
								}
							};

							$scope.VerifierDispoStockGrosPoisson = function() {
								if ($scope.element.poids == undefined) {
									sweetAlert("Erreur",
											"Veuillez saisir un nombre!",
											"error");
									$scope.element.poids = undefined;
									return;
								}
								if ($scope.soldeActuel < $scope.element.poids) {
									sweetAlert(
											"Erreur",
											"Le poids saisi est superieur au solde disponible!",
											"error");
									$scope.element.poids = $scope.soldeActuel;
									return;
								}
							};

							$scope.VerifierDispoStockGrosPoissonExp = function() {
								if ($scope.Expelement.poids == undefined) {
									sweetAlert("Erreur",
											"Veuillez saisir un nombre!",
											"error");
									$scope.Expelement.poids = undefined;
									return;
								}
								if ($scope.ExpsoldeActuel < $scope.Expelement.poids) {
									sweetAlert(
											"Erreur",
											"Le poids saisi est superieur au solde disponible!",
											"error");
									$scope.Expelement.poids = $scope.ExpsoldeActuel;
									return;
								}
							};
							$scope.idStock = 0;
							$scope.ExpidStock = 0;
							$scope.selectedTemplate = function(el1, el2, el3) {
								if ($scope.espececalibre == 'especegrospoisson')
									return;
								if (el1 == undefined || el2 == undefined
										|| el3 == undefined) {
									$scope.element.qualite = undefined;
									sweetAlert(
											"Erreur",
											"Veuillez remplir tous les champs!",
											"error");
								} else {
									$http({
										method : 'GET',
										url : 'GetSoldeActuel',
										dataType : 'json',

										params : {

											espece : el1,
											calibre : el2,
											qualite : el3
										}

									})
											.then(
													function(response) {
														if (response.data.id !== 0) {
															$scope.soldeActuel = response.data.soldeStock;
															$scope.idStock = response.data.id;

															if (response.data.soldeStock <= 0) {
																sweetAlert(
																		"Erreur",
																		"Espece non disponible dans le stock!",
																		"error");
																$scope.idStock = 0;
																$scope.element.qualite = undefined;
																return;
															}
														} else {
															sweetAlert(
																	"Erreur",
																	"Espece non disponible dans le stock!",
																	"error");
															$scope.element.qualite = undefined;
														}

													});
								}

							};
							$scope.selectedTemplateExp = function(el1, el2, el3) {
								if ($scope.espececalibre == 'especegrospoisson')
									return;

								if (el1 == undefined || el2 == undefined
										|| el3 == undefined) {
									$scope.Expelement.qualite = undefined;
									sweetAlert(
											"Erreur",
											"Veuillez remplir tous les champs!",
											"error");
								} else {
									$http({
										method : 'GET',
										url : 'GetSoldeActuel',
										dataType : 'json',

										params : {

											espece : el1,
											calibre : el2,
											qualite : el3
										}

									})
											.then(
													function(response) {
														if (response.data.id !== 0) {
															$scope.ExpsoldeActuel = response.data.soldeStock;
															$scope.ExpidStock = response.data.id;

															if (response.data.soldeStock <= 0) {
																sweetAlert(
																		"Erreur",
																		"Espece non disponible dans le stock!",
																		"error");
																$scope.ExpidStock = 0;
																$scope.Expelement.qualite = undefined;
																return;
															}
														} else {
															sweetAlert(
																	"Erreur",
																	"Espece non disponible dans le stock!",
																	"error");
															$scope.Expelement.qualite = undefined;
														}

													});
								}

							};
							$scope.idStock = 0;
							$scope.GetSoldeActuelGrosPoisson = function() {
								if ($scope.espececalibre != 'especegrospoisson')
									return;
								if ($scope.element.espece == undefined
										|| $scope.element.qualite == undefined) {
									sweetAlert(
											"Erreur",
											"Veuillez remplir tous les champs!",
											"error");
									$scope.element.qualite = undefined;
								} else {
									$http({
										method : 'GET',
										url : 'GetSoldeActuelGrosPoisson',
										dataType : 'json',

										params : {

											espece : $scope.element.espece,
											qualite : $scope.element.qualite
										}

									})
											.then(
													function(response) {
														if (response.data.id !== 0) {
															$scope.soldeActuel = response.data.soldeStock;
															$scope.idStock = response.data.id;
															if (response.data.soldeStock <= 0) {
																sweetAlert(
																		"Erreur",
																		"Espece non disponible dans le stock!",
																		"error");
																$scope.element.qualite = undefined;
																$scope.idStock = 0;
																return;
															}
														} else {
															sweetAlert(
																	"Erreur",
																	"Espece non disponible dans le stock!",
																	"error");
															$scope.element.qualite = undefined;
														}

													});
								}

							};

							$scope.GetSoldeActuelGrosPoissonExp = function() {
								if ($scope.espececalibre != 'especegrospoisson')
									return;
								if ($scope.Expelement.espece == undefined
										|| $scope.Expelement.qualite == undefined) {
									sweetAlert(
											"Erreur",
											"Veuillez remplir tous les champs!",
											"error");
									$scope.Expelement.qualite = undefined;
								} else {
									$http({
										method : 'GET',
										url : 'GetSoldeActuelGrosPoisson',
										dataType : 'json',

										params : {

											espece : $scope.Expelement.espece,
											qualite : $scope.Expelement.qualite
										}

									})
											.then(
													function(response) {
														if (response.data.id !== 0) {
															$scope.ExpsoldeActuel = response.data.soldeStock;
															$scope.ExpidStock = response.data.id;
															if (response.data.soldeStock <= 0) {
																sweetAlert(
																		"Erreur",
																		"Espece non disponible dans le stock!",
																		"error");
																$scope.Expelement.qualite = undefined;
																$scope.ExpidStock = 0;
																return;
															}
														} else {
															sweetAlert(
																	"Erreur",
																	"Espece non disponible dans le stock!",
																	"error");
															$scope.Expelement.qualite = undefined;
														}

													});
								}

							};
							$scope.GetSoldeActuelPourExport = function() {
								if (Expelement.espece == undefined
										|| Expelement.calibre == undefined
										|| Expelement.qualite == undefined) {
									sweetAlert(
											"Erreur",
											"Veuillez remplir tous les champs!",
											"error");
									Expelement.qualite = undefined;
								} else {
									$http({
										method : 'GET',
										url : 'GetSoldeActuel',
										dataType : 'json',

										params : {

											espece : Expelement.espece,
											calibre : Expelement.calibre,
											qualite : Expelement.qualite
										}

									})
											.then(
													function(response) {
														if (response.data.id !== 0) {
															$scope.soldeActuel = response.data.soldeStock;
															$scope.idStock = response.data.id;
														} else {
															sweetAlert(
																	"Erreur",
																	"Espece non disponible dans le stock!",
																	"error");
															element.qualite = undefined;
														}

													});
								}

							};
							$scope.EspeceDemouleeByCodeNonRegle = function() {
								var Code = window.location.href.split("?")[1];
								$scope.listEspecesDemoulees = [];
								$http(
										{
											method : 'GET',
											url : 'EspeceDemouleByCode',
											dataType : 'json',

											params : {
												Code : window.location.href
														.split("?")[1]
											}
										})
										.success(
												function(data) {
													$scope.listEspecesDemoulees = data;
													if ($scope.listEspecesDemoulees.length <= 0) {
														sweetAlert(
																"Erreur",
																"Debarquement deja Facture!",
																"error");
													}
												});

							};
							$scope.EspeceDemouleePourReglerFactureVenteLocale = function() {
								var Code = window.location.href.split("?")[1];
								$scope.listEspecesDemouleesAchetees = [];
								$http(
										{
											method : 'GET',
											url : 'EspeceDemouleePourReglerFactureVenteLocale',
											dataType : 'json',

											params : {
												Code : window.location.href
														.split("?")[1]
											}
										})
										.success(
												function(data) {
													$scope.listEspecesDemouleesAchetees = data;
													if ($scope.listEspecesDemouleesAchetees.length <= 0) {
														sweetAlert(
																"Erreur",
																"Vente Locale deja Facture!",
																"error");
													}
												});

							};

							$scope.EspeceTransportePourReglerFactureExportation = function() {
								var Code = window.location.href.split("?")[1];
								$scope.listEspecesTransportees = [];
								$http(
										{
											method : 'GET',
											url : 'EspeceTransportePourReglerFactureExportation',
											dataType : 'json',

											params : {
												Code : window.location.href
														.split("?")[1]
											}
										})
										.success(
												function(data) {
													$scope.listEspecesTransportees = data;
													if ($scope.listEspecesTransportees.length <= 0) {
														sweetAlert(
																"Erreur",
																"Exportation deja Facture!",
																"error");
													}
												});

							};
							$scope.EspeceTransporteExportation = function() {
								var Code = window.location.href.split("?")[1];
								$scope.listEspecesTransportees = [];
								$http(
										{
											method : 'GET',
											url : 'EspeceTransporteExportation',
											dataType : 'json',

											params : {
												Code : window.location.href
														.split("?")[1]
											}
										})
										.success(
												function(data) {
													$scope.listEspecesTransportees = data;
													if ($scope.listEspecesTransportees.length <= 0) {
														sweetAlert(
																"Erreur",
																"Exportation non disponible!",
																"error");
													}
												});

							};

							$scope.EspeceDemouleeDejaFacturer_VenteLocale = function() {
								var Code = window.location.href.split("?")[1];
								$scope.listEspecesDemouleesAchetees = [];
								$http(
										{
											method : 'GET',
											url : 'EspeceDemouleeDejaFacturer_VenteLocale',
											dataType : 'json',

											params : {
												Code : window.location.href
														.split("?")[1]
											}
										})
										.success(
												function(data) {
													$scope.listEspecesDemouleesAchetees = data;
													if ($scope.listEspecesDemouleesAchetees.length <= 0) {
														sweetAlert(
																"Erreur",
																"Vente Locale deja Facture!",
																"error");
													}
												});

							};

							$scope.EspeceDemoulee_VenteLocalePourModification = function() {
								var Code = window.location.href.split("?")[1];
								$scope.listEspecesDemouleesAchetees = [];
								$http(
										{
											method : 'GET',
											url : 'EspeceDemoulee_VenteLocalePourModification',
											dataType : 'json',

											params : {
												Code : window.location.href
														.split("?")[1]
											}
										})
										.success(
												function(data) {
													$scope.listEspecesDemouleesAchetees = data;
													if ($scope.listEspecesDemouleesAchetees.length <= 0) {
														sweetAlert(
																"Erreur",
																"Vente Locale non disponible",
																"error");
													} else {
														$scope.DateAchat = $scope.listEspecesDemouleesAchetees[0].achat.dateAchat;
														$scope.PrenomClient = $scope.listEspecesDemouleesAchetees[0].achat.client.prenomClient;
														$scope.NomClient = $scope.listEspecesDemouleesAchetees[0].achat.client.nomClient;
													}
												});

							};

							$scope.getListDebarquementRegle = function() {

								$scope.listDebarquement = [];
								$http({
									method : 'GET',
									url : 'listDebarquementRegle',
									dataType : 'json',

									params : {}
								})
										.success(
												function(data) {
													$scope.listDebarquement = data;
													if ($scope.listDebarquement.length <= 0) {
														sweetAlert(
																"Erreur",
																"Aucun Debarquement a regler en Attente!",
																"error");
													}

												});
							};

							$scope.EspeceDemouleeByCodeNonRegle = function() {
								var Code = window.location.href.split("?")[1];
								$scope.listEspecesDemoulees = [];
								$http(
										{
											method : 'GET',
											url : 'EspeceDemouleByCode',
											dataType : 'json',

											params : {
												Code : window.location.href
														.split("?")[1]
											}
										})
										.success(
												function(data) {
													$scope.listEspecesDemoulees = data;
													if ($scope.listEspecesDemoulees.length <= 0) {
														sweetAlert(
																"Erreur",
																"Debarquement deja Facture!",
																"error");
													}
												});

							};
							$scope.getTotal = function() {
								var total = 0;
								for (var i = 0; i < $scope.listEspecesDemoulees.length; i++) {
									var p = $scope.listEspecesDemoulees[i];
									total = total + p.montant;
								}
								if (isNaN(total)) {
									total = 0;
									return total;
								}
								return parseInt(total);
							};

							$scope.getTotalEspeceAchetees = function() {
								var total = 0;
								for (var i = 0; i < $scope.listEspecesDemouleesAchetees.length; i++) {
									var p = $scope.listEspecesDemouleesAchetees[i];
									total = total + p.montant;
								}
								if (isNaN(total)) {
									total = 0;
									return total;
								}
								return parseInt(total);
							};

							$scope.getTotalEspeceExportees = function() {
								var total = 0;
								for (var i = 0; i < $scope.listEspecesTransportees.length; i++) {
									var p = $scope.listEspecesTransportees[i];
									total = total + p.montant;
								}
								if (isNaN(total)) {
									total = 0;
									return total;
								}
								return parseInt(total);
							};

							$scope.saveFactureDebarquement = function() {
								for (var i = 0; i < $scope.listEspecesDemoulees.length; i++) {
									if ($scope.listEspecesDemoulees[i].montant === undefined
											|| isNaN($scope.listEspecesDemoulees[i].montant)
											|| $scope.listEspecesDemoulees[i].montant <= 0
											|| isNaN($scope.listEspecesDemoulees[i].montant)) {
										sweetAlert("Erreur",
												"Remplissez tous les champs!",
												"error");
										return;
									}
								}
								$http(
										{
											method : 'GET',
											url : 'saveFactureDebarquement',
											dataType : 'json',
											params : {
												listespeces : $scope.listEspecesDemoulees
											}
										})
										.then(
												function(response) {
													if (response.data.id != null) {
														sweetAlert(
																"Facturation Reussi!",
																" Veuillez patienter pour l'impression de la Facture!",
																"success");
														$scope.listEspecesDemoulees = {};

													}
												});
							};

							$scope.saveFactureVenteLocale = function() {
								for (var i = 0; i < $scope.listEspecesDemouleesAchetees.length; i++) {
									if ($scope.listEspecesDemouleesAchetees[i].montant === undefined
											|| isNaN($scope.listEspecesDemouleesAchetees[i].montant)
											|| $scope.listEspecesDemouleesAchetees[i].montant <= 0
											|| isNaN($scope.listEspecesDemouleesAchetees[i].montant)) {
										sweetAlert("Erreur",
												"Remplissez tous les champs!",
												"error");
										return;
									}
								}
								$http(
										{
											method : 'GET',
											url : 'saveFactureVenteLocale',
											dataType : 'json',
											params : {
												listespeces : $scope.listEspecesDemouleesAchetees
											}
										})
										.then(
												function(response) {
													if (response.data.id != null) {
														sweetAlert(
																"Facturation Reussi!",
																" Veuillez patienter pour l'impression de la Facture!",
																"success");
														$scope.listEspecesDemouleesAchetees = {};

													}
												});
							};
							$scope.ImprimerFactureVenteLocale = function() {

								$http({
									method : 'GET',
									url : 'ImprimerFactureVenteLocale',
									dataType : 'json',
									params : {
										Code : window.location.href.split("?")[1]
									}
								})

							};

							$scope.saveFactureExportation = function() {
								for (var i = 0; i < $scope.listEspecesTransportees.length; i++) {
									if ($scope.listEspecesTransportees[i].montant === undefined
											|| isNaN($scope.listEspecesTransportees[i].montant)
											|| $scope.listEspecesTransportees[i].montant <= 0
											|| isNaN($scope.listEspecesTransportees[i].montant)) {
										sweetAlert("Erreur",
												"Remplissez tous les champs!",
												"error");
										return;
									}
								}
								$http(
										{
											method : 'GET',
											url : 'saveFactureExportation',
											dataType : 'json',
											params : {
												listespecesExportees : $scope.listEspecesTransportees
											}
										})
										.then(
												function(response) {
													if (response.data.id != null) {
														sweetAlert(
																"Facturation Reussi!",
																" Veuillez patienter pour l'impression de la Facture!",
																"success");
														$scope.listEspecesTransportees = {};

													}
												});
							};

							$scope.getEspeceProduiteByCodePourFacturation = function() {
								var Code = window.location.href.split("?")[1];
								$scope.listEspecesDemoulees = [];
								$http(
										{
											method : 'GET',
											url : 'EspeceDemouleReglePourFacturation',
											dataType : 'json',

											params : {
												Code : window.location.href
														.split("?")[1]
											}
										}).success(function(data) {

									$scope.listEspecesDemoulees = data;

								});
							};

							$scope.getEspeceDemouleByCodePourConsulter = function() {
								var Code = window.location.href.split("?")[1];
								$scope.listEspecesDemoulees = [];
								$http(
										{
											method : 'GET',
											url : 'EspeceDemoulePourConsulter',
											dataType : 'json',

											params : {
												Code : window.location.href
														.split("?")[1]
											}
										}).success(function(data) {

									$scope.listEspecesDemoulees = data;

								});
							};

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
							$scope.moyenTransport = 'camion';
							$scope.VenteLocOuExport = 'Exportation';
							$scope.espececalibre = 'espececalibre';

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
							$scope.NumCont = "";
							$scope.NumPlbs = "";
							$scope.elements = [];
							$scope.add = function(element) {
								if ($scope.element.espece == undefined
										|| $scope.element.qualite == undefined) {
									sweetAlert("Erreur",
											"Remplissez tous les champs!",
											"error");
									return;
								}

								else if ($scope.element.poids <= 0) {
									sweetAlert("Erreur",
											"Poids Saisi est incorrect!",
											"error");
									return;
								} else {
									if ($scope.element.calibre == undefined)
										$scope.element.calibre = "GROS POISSON";
									else {
										if ($scope.element.typecarton != undefined) {
											if ($scope.element.typecarton == "14 KG")
												$scope.element.poids = 14 * $scope.element.nbCarton;

											else if ($scope.element.typecarton == "20 KG")
												$scope.element.poids = 20 * $scope.element.nbCarton;
											else if ($scope.element.typecarton == "28 KG")
												$scope.element.poids = 28 * $scope.element.nbCarton;
										}
										$scope.elements.push(element);
										$scope.NumCont = $scope.element.NumContainer;
										$scope.NumPlbs = $scope.element.NumPlombs;
										$scope.idStock = 0;
										$scope.element = {};
										$scope.element.NumContainer = $scope.NumCont;
										$scope.element.NumPlombs = $scope.NumPlbs;
									}
								}
							};

							$scope.Expelements = [];
							$scope.addExp = function(Expelement) {
								if ($scope.espececalibre = 'espececalibre') {
									if ($scope.Expelement.calibre == undefined
											|| $scope.Expelement.typecarton == undefined
											|| $scope.Expelement.nbCarton == undefined) {
										sweetAlert("Erreur",
												"Remplissez tous les champs!",
												"error");
										$scope.ExpidStock = 0;
										return;
									} else if ($scope.Expelement.nbCarton <= 0) {
										sweetAlert(
												"Erreur",
												"Le nombre de carton saisi est incorrect! Veuillez resaisir un nombre correct!",
												"error");
										$scope.Expelement.nbCarton = undefined;
										return;
									}
								} else {
									if ($scope.Expelement.poids == undefined) {
										sweetAlert("Erreur",
												"Remplissez tous les champs!",
												"error");
										$scope.ExpidStock = 0;
										return;
									}
									if ($scope.Expelement.poids <= 0) {
										sweetAlert("Erreur",
												"Poids Saisi est incorrect!",
												"error");
										$scope.ExpidStock = 0;
										return;
									}
								}
								if ($scope.Expelement.qualite == undefined
										|| $scope.Expelement.espece == undefined) {
									sweetAlert("Erreur",
											"Remplissez tous les champs!",
											"error");
									return;
								}
								if ($scope.Expelement.calibre == undefined)
									$scope.Expelement.calibre = "GROS POISSON";
								else {
									if ($scope.Expelement.typecarton != undefined) {
										if ($scope.Expelement.typecarton == "14 KG")
											$scope.Expelement.poids = 14 * $scope.Expelement.nbCarton;

										else if ($scope.Expelement.typecarton == "20 KG")
											$scope.Expelement.poids = 20 * $scope.Expelement.nbCarton;
										else if ($scope.Expelement.typecarton == "28 KG")
											$scope.Expelement.poids = 28 * $scope.Expelement.nbCarton;
									}
									$scope.Expelements.push(Expelement);
									$scope.NumCont = $scope.Expelement.NumContainer;
									$scope.NumPlbs = $scope.Expelement.NumPlombs;
									$scope.Expelement = {};
									$scope.ExpidStock = 0;
									$scope.Expelement.NumContainer = $scope.NumCont;
									$scope.Expelement.NumPlombs = $scope.NumPlbs;
								}

								// }

							};

						}

				]);
