notebookAppControllers = angular.module('notebookAppControllers', []);

notebookAppControllers.controller('EntryController', ['$scope', 'Entry', function($scope, Entry) {
	$scope.entries = Entry.query();
	$scope.orderProp = 'lastModified';
}]);

notebookAppControllers.controller('EntryCreateController', ['$scope', 'Entry', function($scope, Entry) {
	
}]);

notebookAppControllers.controller('EntryEditController', ['$scope', 'Entry', function($scope, Entry) {
	
}]);

notebookAppControllers.controller('EntryViewController', ['$scope', 'Entry', function($scope, Entry) {
	
}]);


notebookAppControllers.controller('NotebookController', ['$scope', '$location', 'popupService', 'Notebook', function($scope, $location, popupService, Notebook) {
	$scope.notebooks = Notebook.query();
	
	$scope.deleteNotebook = function(notebook) {
		if (popupService.showPopup('Really Delete this?')) {
			notebook.$delete(function() {
				$location.path('/notebooks');
			});
			
			$scope.notebooks = Notebook.query();
		}
	};
	
}]);

notebookAppControllers.controller('NotebookCreateController', ['$scope', '$location', 'Notebook', 'NotebookType', function($scope, $location, Notebook, NotebookType) {
	$scope.notebookTypes = NotebookType.query();
	$scope.notebook = new Notebook();
	$scope.createNotebook = function() {
		$scope.notebook.$save(function() {
			$location.path('/notebooks');
		});
	}
}]);

notebookAppControllers.controller('NotebookEditController', ['$scope', 'Notebook', function($scope, Notebook) {
	
}]);

notebookAppControllers.controller('NotebookViewController', ['$scope', 'Notebook', '$routeParams', function($scope, Notebook, $routeParams) {
	$scope.notebook = Notebook.get({id : $routeParams.id});
}]);