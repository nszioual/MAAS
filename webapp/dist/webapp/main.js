(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! /home/anass/School/Master/ModelRepository/webapp/src/main.ts */"zUnb");


/***/ }),

/***/ "AytR":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
const environment = {
    production: false
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "K070":
/*!*****************************************************************!*\
  !*** ./src/app/components/models-list/models-list.component.ts ***!
  \*****************************************************************/
/*! exports provided: ModelsListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ModelsListComponent", function() { return ModelsListComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ "3Pt+");
/* harmony import */ var file_saver__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! file-saver */ "Iab2");
/* harmony import */ var file_saver__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(file_saver__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var _fortawesome_free_solid_svg_icons__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @fortawesome/free-solid-svg-icons */ "wHSu");
/* harmony import */ var src_app_services_model_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! src/app/services/model.service */ "tB1I");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/common */ "ofXK");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/router */ "tyNb");
/* harmony import */ var _fortawesome_angular_fontawesome__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @fortawesome/angular-fontawesome */ "6NWb");










function ModelsListComponent_tr_33_Template(rf, ctx) { if (rf & 1) {
    const _r4 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["????getCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](0, "tr");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](1, "td");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](3, "td");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](5, "td");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](7, "td");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](9, "td");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](10, "div", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](11, "div", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](12, "button", 17);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](13, "span", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????element"](14, "i", 18);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????element"](15, "fa-icon", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](16, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](17, "Edit");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](18, "button", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????listener"]("click", function ModelsListComponent_tr_33_Template_button_click_18_listener() { _angular_core__WEBPACK_IMPORTED_MODULE_0__["????restoreView"](_r4); const model_r1 = ctx.$implicit; const ctx_r3 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["????nextContext"](); return ctx_r3.download(model_r1); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](19, "span", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????element"](20, "fa-icon", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](21, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](22, "Download");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
} if (rf & 2) {
    const model_r1 = ctx.$implicit;
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["????nextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????textInterpolate"](model_r1.name);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????textInterpolate"](model_r1.description);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????textInterpolate"](model_r1.type);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????textInterpolate"](ctx_r0.getSize(model_r1));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????propertyInterpolate1"]("routerLink", "/models/", model_r1.id, "");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("icon", ctx_r0.faEdit);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("icon", ctx_r0.faDownload);
} }
class ModelsListComponent {
    constructor(modelService) {
        this.modelService = modelService;
        this.faDownload = _fortawesome_free_solid_svg_icons__WEBPACK_IMPORTED_MODULE_3__["faDownload"];
        this.faEdit = _fortawesome_free_solid_svg_icons__WEBPACK_IMPORTED_MODULE_3__["faEdit"];
        this.faPlus = _fortawesome_free_solid_svg_icons__WEBPACK_IMPORTED_MODULE_3__["faPlus"];
        this.name = new _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControl"]('');
    }
    ngOnInit() {
        this.retrieveModels();
    }
    retrieveModels() {
        this.modelService.getAll().subscribe((data) => {
            this.models = data;
            console.log(data);
        }, (error) => {
            console.log(error);
        });
    }
    onKeydown($event) {
        if ($event.key === 'Enter') {
            this.searchName();
        }
    }
    getSize(model) {
        return Object.keys(model.versions).length;
    }
    searchName() {
        this.modelService.findByName(this.name.value).subscribe((data) => {
            this.models = data;
            console.log(data);
        }, (error) => {
            console.log(error);
        });
    }
    download(model) {
        const version = this.getLatestVersion(model);
        console.log(version);
        this.modelService.downloadVersion(version.id).subscribe((data) => {
            console.log(data);
            Object(file_saver__WEBPACK_IMPORTED_MODULE_2__["saveAs"])(data, `${version.name}.${version.type}`);
        }, (error) => {
            console.log(error);
        });
    }
    getLatestVersion(model) {
        return model.versions[model.versions.length - 1];
    }
}
ModelsListComponent.??fac = function ModelsListComponent_Factory(t) { return new (t || ModelsListComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["????directiveInject"](src_app_services_model_service__WEBPACK_IMPORTED_MODULE_4__["ModelService"])); };
ModelsListComponent.??cmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["????defineComponent"]({ type: ModelsListComponent, selectors: [["app-models-list"]], decls: 40, vars: 3, consts: [["aria-label", "breadcrumbs", 1, "breadcrumb", "is-medium"], [1, "is-active"], ["href", "#", "aria-current", "page"], [1, "title", "is-2"], [1, "field", "has-addons"], [1, "control", "is-expanded"], ["type", "text", "placeholder", "Find a model", 1, "input", 3, "formControl", "keydown"], [1, "control"], ["type", "button", 1, "button", "is-info", 3, "click"], [1, "box"], [1, "table", "is-narrow", "is-striped", "is-fullwidth"], [4, "ngFor", "ngForOf"], [1, "field", "has-addons", "is-pulled-right"], ["routerLink", "/add", "type", "button", 1, "button", "is-primary"], [1, "icon", "is-small"], [3, "icon"], [1, "field", "is-grouped"], [1, "button", "is-info", 3, "routerLink"], [1, "fas", "fa-bold"], ["type", "button is-link", 1, "button", 3, "click"]], template: function ModelsListComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](0, "nav", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](1, "ul");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](2, "li", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](3, "a", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](4, "Models");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](5, "h1", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](6, "Models List");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](7, "div", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](8, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](9, "input", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????listener"]("keydown", function ModelsListComponent_Template_input_keydown_9_listener($event) { return ctx.onKeydown($event); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](10, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](11, "button", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????listener"]("click", function ModelsListComponent_Template_button_click_11_listener() { return ctx.searchName(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](12, " Search ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](13, "div", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](14, "table", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](15, "thead");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](16, "tr");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](17, "th");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](18, "abbr");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](19, "Name");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](20, "th");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](21, "abbr");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](22, "Description");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](23, "th");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](24, "abbr");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](25, "Type");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](26, "th");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](27, "abbr");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](28, "Version");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](29, "th");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](30, "abbr");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](31, "Actions");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](32, "tbody");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????template"](33, ModelsListComponent_tr_33_Template, 23, 7, "tr", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](34, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](35, "button", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](36, "span", 14);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????element"](37, "fa-icon", 15);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](38, "span");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](39, "Add Model");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("formControl", ctx.name);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](24);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("ngForOf", ctx.models);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("icon", ctx.faPlus);
    } }, directives: [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["DefaultValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControlDirective"], _angular_common__WEBPACK_IMPORTED_MODULE_5__["NgForOf"], _angular_router__WEBPACK_IMPORTED_MODULE_6__["RouterLink"], _fortawesome_angular_fontawesome__WEBPACK_IMPORTED_MODULE_7__["FaIconComponent"]], styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJtb2RlbHMtbGlzdC5jb21wb25lbnQuY3NzIn0= */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["??setClassMetadata"](ModelsListComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-models-list',
                templateUrl: './models-list.component.html',
                styleUrls: ['./models-list.component.css'],
            }]
    }], function () { return [{ type: src_app_services_model_service__WEBPACK_IMPORTED_MODULE_4__["ModelService"] }]; }, null); })();


/***/ }),

/***/ "OqeQ":
/*!*********************************************************************!*\
  !*** ./src/app/components/model-details/model-details.component.ts ***!
  \*********************************************************************/
/*! exports provided: ModelDetailsComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ModelDetailsComponent", function() { return ModelDetailsComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ "3Pt+");
/* harmony import */ var file_saver__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! file-saver */ "Iab2");
/* harmony import */ var file_saver__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(file_saver__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var _fortawesome_free_solid_svg_icons__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @fortawesome/free-solid-svg-icons */ "wHSu");
/* harmony import */ var _services_model_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../services/model.service */ "tB1I");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ "tyNb");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/common */ "ofXK");
/* harmony import */ var _fortawesome_angular_fontawesome__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @fortawesome/angular-fontawesome */ "6NWb");










function ModelDetailsComponent_div_18_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](0, "div", 29);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](1, "sup");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](2, "*");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](3, "Name is required ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
} }
function ModelDetailsComponent_div_19_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](0, "div", 29);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](1, "sup");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](2, "*");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](3, "Name must be at least 2 characters long ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
} }
function ModelDetailsComponent_div_20_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](0, "div", 29);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](1, "sup");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](2, "*");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](3, "Name has a maximum of 30 characters ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
} }
function ModelDetailsComponent_div_21_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](0, "div", 29);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](1, "sup");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](2, "*");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](3, "No special characters are allowed ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
} }
function ModelDetailsComponent_div_27_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](0, "div", 29);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](1, "sup");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](2, "*");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](3, "Description is required ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
} }
function ModelDetailsComponent_div_28_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](0, "div", 29);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](1, "sup");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](2, "*");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](3, "Description must be at least 2 characters long ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
} }
function ModelDetailsComponent_div_29_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](0, "div", 29);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](1, "sup");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](2, "*");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](3, "Description has a maximum of 350 characters ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
} }
function ModelDetailsComponent_tr_72_Template(rf, ctx) { if (rf & 1) {
    const _r11 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["????getCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](0, "tr");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](1, "td");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](3, "td");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](5, "td");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](6, "button", 30);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????listener"]("click", function ModelDetailsComponent_tr_72_Template_button_click_6_listener() { _angular_core__WEBPACK_IMPORTED_MODULE_0__["????restoreView"](_r11); const version_r8 = ctx.$implicit; const ctx_r10 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["????nextContext"](); return ctx_r10.download(version_r8); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](7, "span", 31);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????element"](8, "fa-icon", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](9, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](10, "Download");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
} if (rf & 2) {
    const version_r8 = ctx.$implicit;
    const ctx_r7 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["????nextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????textInterpolate"](version_r8.version_number);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????textInterpolate"](version_r8.name);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("icon", ctx_r7.faDownload);
} }
class ModelDetailsComponent {
    constructor(fb, modelService, route, router) {
        this.fb = fb;
        this.modelService = modelService;
        this.route = route;
        this.router = router;
        this.faUpload = _fortawesome_free_solid_svg_icons__WEBPACK_IMPORTED_MODULE_3__["faUpload"];
        this.faDownload = _fortawesome_free_solid_svg_icons__WEBPACK_IMPORTED_MODULE_3__["faDownload"];
        this.submitted = false;
        this.versions = null;
        this.selectedFile = null;
        this.selectedFileName = '';
        this.message = '';
    }
    ngOnInit() {
        this.currentModelForm = this.fb.group({
            id: [''],
            name: [
                '',
                [
                    _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required,
                    _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].minLength(2),
                    _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].maxLength(30),
                    _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].pattern('^[_A-z0-9]*((-|s)*[_A-z0-9])*$'),
                ],
            ],
            type: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required]],
            description: [
                '',
                [
                    _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required,
                    _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].minLength(2),
                    _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].maxLength(350),
                ],
            ],
            file_name: [''],
            file: [null],
        });
        this.getModel(this.route.snapshot.paramMap.get('id'));
    }
    setFile(event) {
        this.selectedFile = event.target.files[0];
        this.selectedFileName = this.selectedFile.name;
        this.currentModelForm.patchValue({
            type: this.selectedFile.name.split('.').pop(),
        });
    }
    getModel(id) {
        this.modelService.get(id).subscribe((data) => {
            this.currentModelForm.patchValue({
                id: data.id,
                name: data.name,
                type: data.type,
                description: data.description,
                file_name: data.file_name,
                file: data.file,
            });
            this.versions = data.versions;
            console.log(data);
        }, (error) => {
            console.log(error);
        });
    }
    get modelFormControl() {
        return this.currentModelForm.controls;
    }
    updateModel() {
        this.submitted = true;
        if (this.currentModelForm.valid) {
            const formData = new FormData();
            formData.append('model', new Blob([JSON.stringify(this.currentModelForm.value)], {
                type: 'application/json',
            }));
            if (this.selectedFile) {
                formData.append('file', this.selectedFile, this.selectedFile.name);
            }
            this.modelService
                .update(this.currentModelForm.get('id').value, formData)
                .subscribe((data) => {
                console.log(data);
                this.message = 'The model was updated successfully!';
                this.versions = data.versions;
                this.submitted = false;
            }, (error) => {
                console.log(error);
            });
        }
    }
    deleteModel() {
        this.modelService.delete(this.currentModelForm.get('id').value).subscribe((response) => {
            console.log(response);
            this.router.navigate(['/models']);
        }, (error) => {
            console.log(error);
        });
    }
    download(version) {
        this.modelService.downloadVersion(version.id).subscribe((data) => {
            console.log(data);
            Object(file_saver__WEBPACK_IMPORTED_MODULE_2__["saveAs"])(data, `${version.name}.${version.type}`);
        }, (error) => {
            console.log(error);
        });
    }
}
ModelDetailsComponent.??fac = function ModelDetailsComponent_Factory(t) { return new (t || ModelDetailsComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["????directiveInject"](_angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormBuilder"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["????directiveInject"](_services_model_service__WEBPACK_IMPORTED_MODULE_4__["ModelService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["????directiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__["ActivatedRoute"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["????directiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__["Router"])); };
ModelDetailsComponent.??cmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["????defineComponent"]({ type: ModelDetailsComponent, selectors: [["app-model-details"]], decls: 73, vars: 12, consts: [["aria-label", "breadcrumbs", 1, "breadcrumb", "is-medium"], ["href", "#"], [1, "is-active"], ["href", "#", "aria-current", "page"], [1, "title", "is-2"], [1, "box", "columns"], [1, "column", "is-half"], [3, "formGroup", "ngSubmit"], [1, "field", "form-group"], [1, "label"], [1, "control"], ["id", "name", "formControlName", "name", "required", "", "type", "text", "required", "", "placeholder", "Name of the model", 1, "input"], ["class", "invalid-feedback", 4, "ngIf"], ["id", "description", "formControlName", "description", "required", "", "placeholder", "Description of the model", 1, "textarea"], ["disabled", "", "formControlName", "type", "type", "text", 1, "input"], [1, "file", "field", "form-group", "has-name"], [1, "file-label"], ["id", "file", "accept", ".uml, .sysml, .bpmn", "type", "file", 1, "file-input", 3, "change"], [1, "file-cta"], [1, "file-icon"], [3, "icon"], [1, "file-name"], [1, "field", "is-grouped"], ["type", "submit", 1, "button", "is-link"], ["type", "button", 1, "button", "is-danger", 3, "click"], ["type", "button", "routerLink", "..", 1, "button", "is-info", "is-light"], [1, "table-container"], [1, "table", "is-narrow", "is-striped", "is-fullwidth"], [4, "ngFor", "ngForOf"], [1, "invalid-feedback"], ["type", "button is-link", 1, "button", 3, "click"], [1, "icon", "is-small"]], template: function ModelDetailsComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](0, "nav", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](1, "ul");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](2, "li");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](3, "a", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](4, "Models");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](5, "li", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](6, "a", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](7, "Update");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](8, "h1", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](9, "Update Model");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](10, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](11, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](12, "form", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????listener"]("ngSubmit", function ModelDetailsComponent_Template_form_ngSubmit_12_listener() { return ctx.updateModel(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](13, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](14, "label", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](15, "Name");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](16, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????element"](17, "input", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????template"](18, ModelDetailsComponent_div_18_Template, 4, 0, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????template"](19, ModelDetailsComponent_div_19_Template, 4, 0, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????template"](20, ModelDetailsComponent_div_20_Template, 4, 0, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????template"](21, ModelDetailsComponent_div_21_Template, 4, 0, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](22, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](23, "label", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](24, "Description");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](25, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????element"](26, "textarea", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????template"](27, ModelDetailsComponent_div_27_Template, 4, 0, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????template"](28, ModelDetailsComponent_div_28_Template, 4, 0, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????template"](29, ModelDetailsComponent_div_29_Template, 4, 0, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](30, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](31, "label", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](32, "Type");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](33, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????element"](34, "input", 14);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](35, "div", 15);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](36, "label", 16);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](37, "input", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????listener"]("change", function ModelDetailsComponent_Template_input_change_37_listener($event) { return ctx.setFile($event); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](38, "span", 18);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](39, "span", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????element"](40, "fa-icon", 20);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](41, "span", 16);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](42, " Upload ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](43, "span", 21);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](44);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](45, "div", 22);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](46, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](47, "button", 23);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](48, "Update");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](49, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](50, "button", 24);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????listener"]("click", function ModelDetailsComponent_Template_button_click_50_listener() { return ctx.deleteModel(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](51, " Delete ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](52, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](53, "button", 25);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](54, " Return ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](55, "p");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](56);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](57, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](58, "div", 26);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](59, "table", 27);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](60, "thead");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](61, "tr");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](62, "th");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](63, "abbr");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](64, "Version");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](65, "th");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](66, "abbr");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](67, "Name");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](68, "th");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](69, "abbr");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](70, "Actions");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](71, "tbody");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????template"](72, ModelDetailsComponent_tr_72_Template, 11, 3, "tr", 28);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("formGroup", ctx.currentModelForm);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("ngIf", (ctx.modelFormControl.name.touched || ctx.submitted) && (ctx.modelFormControl.name.errors == null ? null : ctx.modelFormControl.name.errors.required));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("ngIf", (ctx.modelFormControl.name.touched || ctx.submitted) && (ctx.modelFormControl.name.errors == null ? null : ctx.modelFormControl.name.errors.minlength));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("ngIf", (ctx.modelFormControl.name.touched || ctx.submitted) && (ctx.modelFormControl.name.errors == null ? null : ctx.modelFormControl.name.errors.maxlength));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("ngIf", (ctx.modelFormControl.name.touched || ctx.submitted) && (ctx.modelFormControl.name.errors == null ? null : ctx.modelFormControl.name.errors.pattern));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("ngIf", (ctx.modelFormControl.description.touched || ctx.submitted) && (ctx.modelFormControl.description.errors == null ? null : ctx.modelFormControl.description.errors.required));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("ngIf", (ctx.modelFormControl.description.touched || ctx.submitted) && (ctx.modelFormControl.description.errors == null ? null : ctx.modelFormControl.description.errors.minlength));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("ngIf", (ctx.modelFormControl.description.touched || ctx.submitted) && (ctx.modelFormControl.description.errors == null ? null : ctx.modelFormControl.description.errors.maxlength));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("icon", ctx.faUpload);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????textInterpolate1"](" ", ctx.selectedFileName, " ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????textInterpolate"](ctx.message);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](16);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("ngForOf", ctx.versions);
    } }, directives: [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["??angular_packages_forms_forms_y"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatusGroup"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormGroupDirective"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["DefaultValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControlName"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["RequiredValidator"], _angular_common__WEBPACK_IMPORTED_MODULE_6__["NgIf"], _fortawesome_angular_fontawesome__WEBPACK_IMPORTED_MODULE_7__["FaIconComponent"], _angular_router__WEBPACK_IMPORTED_MODULE_5__["RouterLink"], _angular_common__WEBPACK_IMPORTED_MODULE_6__["NgForOf"]], styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJtb2RlbC1kZXRhaWxzLmNvbXBvbmVudC5jc3MifQ== */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["??setClassMetadata"](ModelDetailsComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-model-details',
                templateUrl: './model-details.component.html',
                styleUrls: ['./model-details.component.css'],
            }]
    }], function () { return [{ type: _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormBuilder"] }, { type: _services_model_service__WEBPACK_IMPORTED_MODULE_4__["ModelService"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_5__["ActivatedRoute"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_5__["Router"] }]; }, null); })();


/***/ }),

/***/ "Sy1n":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "tyNb");



class AppComponent {
    constructor() {
        this.title = 'webapp';
    }
}
AppComponent.??fac = function AppComponent_Factory(t) { return new (t || AppComponent)(); };
AppComponent.??cmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["????defineComponent"]({ type: AppComponent, selectors: [["app-root"]], decls: 16, vars: 0, consts: [["role", "navigation", "aria-label", "main navigation", 1, "navbar", "is-dark"], [1, "navbar-brand"], ["href", "#", 1, "navbar-item"], [1, "navbar-menu"], [1, "navbar-start"], ["routerLink", "models", 1, "navbar-item"], ["routerLink", "add", 1, "navbar-item"], [1, "section"], [1, "columns", "is-centered"], [1, "column", "is-three-fifths"], [1, "container"]], template: function AppComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](0, "div");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](1, "nav", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](2, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](3, "a", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](4, " Arrowhead ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](5, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](6, "div", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](7, "a", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](8, " Models ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](9, "a", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](10, " Upload ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](11, "section", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](12, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](13, "div", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](14, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????element"](15, "router-outlet");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    } }, directives: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterLinkWithHref"], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterOutlet"]], styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJhcHAuY29tcG9uZW50LmNzcyJ9 */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["??setClassMetadata"](AppComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-root',
                templateUrl: './app.component.html',
                styleUrls: ['./app.component.css']
            }]
    }], null, null); })();


/***/ }),

/***/ "ZAI4":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/platform-browser */ "jhN1");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var _app_routing_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app-routing.module */ "vY5A");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./app.component */ "Sy1n");
/* harmony import */ var _components_add_model_add_model_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./components/add-model/add-model.component */ "mwzl");
/* harmony import */ var _components_model_details_model_details_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./components/model-details/model-details.component */ "OqeQ");
/* harmony import */ var _components_models_list_models_list_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./components/models-list/models-list.component */ "K070");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/forms */ "3Pt+");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/common/http */ "tk/3");
/* harmony import */ var _fortawesome_angular_fontawesome__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @fortawesome/angular-fontawesome */ "6NWb");











class AppModule {
}
AppModule.??mod = _angular_core__WEBPACK_IMPORTED_MODULE_1__["????defineNgModule"]({ type: AppModule, bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]] });
AppModule.??inj = _angular_core__WEBPACK_IMPORTED_MODULE_1__["????defineInjector"]({ factory: function AppModule_Factory(t) { return new (t || AppModule)(); }, providers: [], imports: [[
            _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
            _app_routing_module__WEBPACK_IMPORTED_MODULE_2__["AppRoutingModule"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_7__["ReactiveFormsModule"],
            _angular_common_http__WEBPACK_IMPORTED_MODULE_8__["HttpClientModule"],
            _fortawesome_angular_fontawesome__WEBPACK_IMPORTED_MODULE_9__["FontAwesomeModule"],
        ]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_1__["????setNgModuleScope"](AppModule, { declarations: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"],
        _components_add_model_add_model_component__WEBPACK_IMPORTED_MODULE_4__["AddModelComponent"],
        _components_model_details_model_details_component__WEBPACK_IMPORTED_MODULE_5__["ModelDetailsComponent"],
        _components_models_list_models_list_component__WEBPACK_IMPORTED_MODULE_6__["ModelsListComponent"]], imports: [_angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
        _app_routing_module__WEBPACK_IMPORTED_MODULE_2__["AppRoutingModule"],
        _angular_forms__WEBPACK_IMPORTED_MODULE_7__["ReactiveFormsModule"],
        _angular_common_http__WEBPACK_IMPORTED_MODULE_8__["HttpClientModule"],
        _fortawesome_angular_fontawesome__WEBPACK_IMPORTED_MODULE_9__["FontAwesomeModule"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_1__["??setClassMetadata"](AppModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"],
        args: [{
                declarations: [
                    _app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"],
                    _components_add_model_add_model_component__WEBPACK_IMPORTED_MODULE_4__["AddModelComponent"],
                    _components_model_details_model_details_component__WEBPACK_IMPORTED_MODULE_5__["ModelDetailsComponent"],
                    _components_models_list_models_list_component__WEBPACK_IMPORTED_MODULE_6__["ModelsListComponent"],
                ],
                imports: [
                    _angular_platform_browser__WEBPACK_IMPORTED_MODULE_0__["BrowserModule"],
                    _app_routing_module__WEBPACK_IMPORTED_MODULE_2__["AppRoutingModule"],
                    _angular_forms__WEBPACK_IMPORTED_MODULE_7__["ReactiveFormsModule"],
                    _angular_common_http__WEBPACK_IMPORTED_MODULE_8__["HttpClientModule"],
                    _fortawesome_angular_fontawesome__WEBPACK_IMPORTED_MODULE_9__["FontAwesomeModule"],
                ],
                providers: [],
                bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]],
            }]
    }], null, null); })();


/***/ }),

/***/ "mwzl":
/*!*************************************************************!*\
  !*** ./src/app/components/add-model/add-model.component.ts ***!
  \*************************************************************/
/*! exports provided: AddModelComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AddModelComponent", function() { return AddModelComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ "3Pt+");
/* harmony import */ var _fortawesome_free_solid_svg_icons__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @fortawesome/free-solid-svg-icons */ "wHSu");
/* harmony import */ var src_app_services_model_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! src/app/services/model.service */ "tB1I");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "tyNb");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/common */ "ofXK");
/* harmony import */ var _fortawesome_angular_fontawesome__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @fortawesome/angular-fontawesome */ "6NWb");









function AddModelComponent_div_18_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](0, "div", 25);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](1, "sup");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](2, "*");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](3, "Name is required ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
} }
function AddModelComponent_div_19_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](0, "div", 25);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](1, "sup");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](2, "*");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](3, "Name must be at least 2 characters long ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
} }
function AddModelComponent_div_20_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](0, "div", 25);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](1, "sup");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](2, "*");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](3, "Name has a maximum of 30 characters ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
} }
function AddModelComponent_div_21_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](0, "div", 25);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](1, "sup");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](2, "*");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](3, "No special characters are allowed ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
} }
function AddModelComponent_div_27_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](0, "div", 25);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](1, "sup");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](2, "*");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](3, "Description is required ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
} }
function AddModelComponent_div_28_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](0, "div", 25);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](1, "sup");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](2, "*");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](3, "Description must be at least 2 characters long ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
} }
function AddModelComponent_div_29_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](0, "div", 25);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](1, "sup");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](2, "*");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](3, "Description has a maximum of 350 characters ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
} }
function AddModelComponent_div_46_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](0, "div", 25);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](1, "sup");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](2, "*");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](3, "File is required ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
} }
class AddModelComponent {
    constructor(fb, modelService, router) {
        this.fb = fb;
        this.modelService = modelService;
        this.router = router;
        this.faUpload = _fortawesome_free_solid_svg_icons__WEBPACK_IMPORTED_MODULE_2__["faUpload"];
        this.submitted = false;
        this.selectedFile = null;
        this.selectedFileName = '';
    }
    ngOnInit() {
        this.modelForm = this.fb.group({
            name: [
                '',
                [
                    _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required,
                    _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].minLength(2),
                    _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].maxLength(30),
                    _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].pattern('^[_A-z0-9]*((-|s)*[_A-z0-9])*$'),
                ],
            ],
            type: ['', [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required]],
            description: [
                '',
                [
                    _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required,
                    _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].minLength(2),
                    _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].maxLength(350),
                ],
            ],
        });
    }
    setFile(event) {
        this.selectedFile = event.target.files[0];
        this.selectedFileName = this.selectedFile.name;
        this.modelForm.patchValue({
            type: this.selectedFile.name.split('.').pop(),
        });
    }
    get modelFormControl() {
        return this.modelForm.controls;
    }
    saveModel() {
        this.submitted = true;
        if (this.modelForm.valid) {
            const formData = new FormData();
            formData.append('file', this.selectedFile, this.selectedFile.name);
            formData.append('model', new Blob([JSON.stringify(this.modelForm.value)], {
                type: 'application/json',
            }));
            this.modelService.create(formData).subscribe((response) => {
                console.log(response);
                this.router.navigate(['/models']);
            }, (error) => {
                console.log(error);
            });
        }
    }
}
AddModelComponent.??fac = function AddModelComponent_Factory(t) { return new (t || AddModelComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["????directiveInject"](_angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormBuilder"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["????directiveInject"](src_app_services_model_service__WEBPACK_IMPORTED_MODULE_3__["ModelService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["????directiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"])); };
AddModelComponent.??cmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["????defineComponent"]({ type: AddModelComponent, selectors: [["app-add-model"]], decls: 54, vars: 11, consts: [["aria-label", "breadcrumbs", 1, "breadcrumb", "is-medium"], ["href", "#"], [1, "is-active"], ["href", "#", "aria-current", "page"], [1, "title", "is-2"], [3, "formGroup", "ngSubmit"], [1, "box"], [1, "column", "is-half"], [1, "field", "form-group"], [1, "label"], [1, "control"], ["id", "name", "formControlName", "name", "required", "", "type", "text", "required", "", "placeholder", "Name of the model", 1, "input"], ["class", "invalid-feedback", 4, "ngIf"], ["id", "description", "formControlName", "description", "required", "", "placeholder", "Description of the model", 1, "textarea"], ["disabled", "", "formControlName", "type", "type", "text", 1, "input"], [1, "file", "has-name"], [1, "file-label"], ["id", "file", "accept", ".uml, .sysml, .bpmn", "type", "file", 1, "file-input", 3, "change"], [1, "file-cta"], [1, "file-icon"], [3, "icon"], [1, "file-name"], [1, "field", "is-grouped"], ["type", "submit", 1, "button", "is-primary"], ["type", "button", "routerLink", "..", 1, "button", "is-link", "is-light"], [1, "invalid-feedback"]], template: function AddModelComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](0, "nav", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](1, "ul");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](2, "li");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](3, "a", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](4, "Models");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](5, "li", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](6, "a", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](7, "Upload");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](8, "h1", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](9, "Upload Model");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](10, "form", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????listener"]("ngSubmit", function AddModelComponent_Template_form_ngSubmit_10_listener() { return ctx.saveModel(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](11, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](12, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](13, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](14, "label", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](15, "Name");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](16, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????element"](17, "input", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????template"](18, AddModelComponent_div_18_Template, 4, 0, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????template"](19, AddModelComponent_div_19_Template, 4, 0, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????template"](20, AddModelComponent_div_20_Template, 4, 0, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????template"](21, AddModelComponent_div_21_Template, 4, 0, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](22, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](23, "label", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](24, "Description");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](25, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????element"](26, "textarea", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????template"](27, AddModelComponent_div_27_Template, 4, 0, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????template"](28, AddModelComponent_div_28_Template, 4, 0, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????template"](29, AddModelComponent_div_29_Template, 4, 0, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](30, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](31, "label", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](32, "Type");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](33, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????element"](34, "input", 14);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](35, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](36, "div", 15);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](37, "label", 16);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](38, "input", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????listener"]("change", function AddModelComponent_Template_input_change_38_listener($event) { return ctx.setFile($event); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](39, "span", 18);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](40, "span", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????element"](41, "fa-icon", 20);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](42, "span", 16);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](43, " Upload ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](44, "span", 21);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](45);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????template"](46, AddModelComponent_div_46_Template, 4, 0, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](47, "div", 22);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](48, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](49, "button", 23);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](50, "Submit");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](51, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementStart"](52, "button", 24);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????text"](53, " Cancel ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????elementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("formGroup", ctx.modelForm);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("ngIf", (ctx.modelFormControl.name.touched || ctx.submitted) && (ctx.modelFormControl.name.errors == null ? null : ctx.modelFormControl.name.errors.required));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("ngIf", (ctx.modelFormControl.name.touched || ctx.submitted) && (ctx.modelFormControl.name.errors == null ? null : ctx.modelFormControl.name.errors.minlength));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("ngIf", (ctx.modelFormControl.name.touched || ctx.submitted) && (ctx.modelFormControl.name.errors == null ? null : ctx.modelFormControl.name.errors.maxlength));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("ngIf", (ctx.modelFormControl.name.touched || ctx.submitted) && (ctx.modelFormControl.name.errors == null ? null : ctx.modelFormControl.name.errors.pattern));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("ngIf", (ctx.modelFormControl.description.touched || ctx.submitted) && (ctx.modelFormControl.description.errors == null ? null : ctx.modelFormControl.description.errors.required));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("ngIf", (ctx.modelFormControl.description.touched || ctx.submitted) && (ctx.modelFormControl.description.errors == null ? null : ctx.modelFormControl.description.errors.minlength));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("ngIf", (ctx.modelFormControl.description.touched || ctx.submitted) && (ctx.modelFormControl.description.errors == null ? null : ctx.modelFormControl.description.errors.maxlength));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("icon", ctx.faUpload);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????textInterpolate1"](" ", ctx.selectedFileName, " ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????advance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["????property"]("ngIf", ctx.submitted && (ctx.modelFormControl.type.errors == null ? null : ctx.modelFormControl.type.errors.required));
    } }, directives: [_angular_forms__WEBPACK_IMPORTED_MODULE_1__["??angular_packages_forms_forms_y"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatusGroup"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormGroupDirective"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["DefaultValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormControlName"], _angular_forms__WEBPACK_IMPORTED_MODULE_1__["RequiredValidator"], _angular_common__WEBPACK_IMPORTED_MODULE_5__["NgIf"], _fortawesome_angular_fontawesome__WEBPACK_IMPORTED_MODULE_6__["FaIconComponent"], _angular_router__WEBPACK_IMPORTED_MODULE_4__["RouterLink"]], styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJhZGQtbW9kZWwuY29tcG9uZW50LmNzcyJ9 */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["??setClassMetadata"](AddModelComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-add-model',
                templateUrl: './add-model.component.html',
                styleUrls: ['./add-model.component.css'],
            }]
    }], function () { return [{ type: _angular_forms__WEBPACK_IMPORTED_MODULE_1__["FormBuilder"] }, { type: src_app_services_model_service__WEBPACK_IMPORTED_MODULE_3__["ModelService"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"] }]; }, null); })();


/***/ }),

/***/ "tB1I":
/*!*******************************************!*\
  !*** ./src/app/services/model.service.ts ***!
  \*******************************************/
/*! exports provided: ModelService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ModelService", function() { return ModelService; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "tk/3");



const baseUrl = 'http://localhost:8890/models';
class ModelService {
    constructor(http) {
        this.http = http;
    }
    getAll() {
        return this.http.get(baseUrl);
    }
    get(id) {
        return this.http.get(`${baseUrl}/${id}`);
    }
    create(data) {
        return this.http.post(`${baseUrl}/add`, data);
    }
    update(id, data) {
        return this.http.put(`${baseUrl}/${id}`, data);
    }
    delete(id) {
        return this.http.delete(`${baseUrl}/${id}`, { responseType: 'text' });
    }
    findByName(name) {
        return this.http.get(`${baseUrl}?name=${name}`);
    }
    downloadVersion(id) {
        return this.http.get(`${baseUrl}/download/version/${id}`, { responseType: 'blob' });
    }
}
ModelService.??fac = function ModelService_Factory(t) { return new (t || ModelService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["????inject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"])); };
ModelService.??prov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["????defineInjectable"]({ token: ModelService, factory: ModelService.??fac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["??setClassMetadata"](ModelService, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{
                providedIn: 'root',
            }]
    }], function () { return [{ type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"] }]; }, null); })();


/***/ }),

/***/ "vY5A":
/*!***************************************!*\
  !*** ./src/app/app-routing.module.ts ***!
  \***************************************/
/*! exports provided: AppRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppRoutingModule", function() { return AppRoutingModule; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "tyNb");
/* harmony import */ var _components_models_list_models_list_component__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./components/models-list/models-list.component */ "K070");
/* harmony import */ var _components_model_details_model_details_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./components/model-details/model-details.component */ "OqeQ");
/* harmony import */ var _components_add_model_add_model_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./components/add-model/add-model.component */ "mwzl");







const routes = [
    { path: '', redirectTo: 'models', pathMatch: 'full' },
    { path: 'models', component: _components_models_list_models_list_component__WEBPACK_IMPORTED_MODULE_2__["ModelsListComponent"] },
    { path: 'models/:id', component: _components_model_details_model_details_component__WEBPACK_IMPORTED_MODULE_3__["ModelDetailsComponent"] },
    { path: 'add', component: _components_add_model_add_model_component__WEBPACK_IMPORTED_MODULE_4__["AddModelComponent"] }
];
class AppRoutingModule {
}
AppRoutingModule.??mod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["????defineNgModule"]({ type: AppRoutingModule });
AppRoutingModule.??inj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["????defineInjector"]({ factory: function AppRoutingModule_Factory(t) { return new (t || AppRoutingModule)(); }, imports: [[_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes)], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["????setNgModuleScope"](AppRoutingModule, { imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]], exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["??setClassMetadata"](AppRoutingModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                imports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes)],
                exports: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"]]
            }]
    }], null, null); })();


/***/ }),

/***/ "zUnb":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "fXoL");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./environments/environment */ "AytR");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "ZAI4");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/platform-browser */ "jhN1");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
_angular_platform_browser__WEBPACK_IMPORTED_MODULE_3__["platformBrowser"]().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(err => console.error(err));


/***/ }),

/***/ "zn8P":
/*!******************************************************!*\
  !*** ./$$_lazy_route_resource lazy namespace object ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "zn8P";

/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map