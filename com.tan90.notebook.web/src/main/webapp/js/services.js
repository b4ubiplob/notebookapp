notebookAppServices = angular.module('notebookAppServices', ['ngResource']);

baseUrl = 'http://localhost:8080/com.tan90.notebook.web';

notebookAppServices.factory('Notebook', function($resource) {
	return $resource(baseUrl + '/api/notebooks/:id', {id :'@id'}, {
			update : {
				method : 'PUT'
			}
		}
	);
});

notebookAppServices.factory('Entry', function($resource) {
	return $resource(baseUrl + '/api/entries/:id', {id :'@id'}, {
			update : {
				method : 'PUT'
			}
		}
	);
});

notebookAppServices.factory('NotebookType', function($resource) {
	return $resource(baseUrl + '/api/notebooks/types/:id', {id :'@id'}, {
			update : {
				method : 'PUT'
			}
		}
	);
});

notebookAppServices.service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});