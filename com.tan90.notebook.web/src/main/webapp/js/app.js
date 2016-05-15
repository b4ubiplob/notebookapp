notebookApp = angular.module('notebookApp', ['ngRoute', 'notebookAppControllers', 'notebookAppServices']);

notebookApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/entries', {
		templateUrl : 'partials/entries.html',
		controller : 'EntryController'
	}).when('/entries/:id/view', {
		templateUrl : 'partials/entry_view.html',
		controller : 'EntryViewController'
	}).when('/entries/new', {
		templateUrl : 'partials/entry_create.html',
		controller : 'EntryCreateController'
	}).when('/entries/:id/edit', {
		templateUrl : 'partials/entry_edit.html',
		controller : 'EntryEditController'
	}).when('/notebooks', {
		templateUrl : 'partials/notebooks.html',
		controller : 'NotebookController'
	}).when('/notebooks/:id/view', {
		templateUrl : 'partials/notebook_view.html',
		controller : 'NotebookViewController'
	}).when('/notebooks/new', {
		templateUrl : 'partials/notebook_create.html',
		controller : 'NotebookCreateController'
	}).when('/notebooks/:id/edit', {
		templateUrl : 'partials/notebook_edit.html',
		controller : 'NotebookEditController'
	}).otherwise({
		redirectTo: '/entries'
	});
}]);