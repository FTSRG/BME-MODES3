/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Section Controller Class
 * 
 * Section Controller Class instances are mainly responsible for displaying 
 * one section's occupancy and enabled/disabled status on screen.
 * 
 */

function SegmentController(segmentConfig, stateController, controlKey) {
    // setting up instance variables
    this.config = segmentConfig;
    this.svgElem = $('#layout').find("#"+this.config.id);
    this.controlKey = controlKey;
    this.stateController = stateController;
    
    // first, we don't know the state of the segment
    setTrackElementColor(this.svgElem, window.settings.segment.undefinedStateColor);
    
    // no need for initializing sequence, everything need to done in dom updated
    // callback to be sure its active every time
};

SegmentController.prototype.setEnabled = function () {
    // send state control message over transport layer
    this.stateController.pushSegmentState(this.controlKey, 1);
    
    // updating UI
    setTrackElementColor(this.svgElem, window.settings.segment.activeColor);
    this.isSegmentEnabled = true;
    logEvent("Segment #" + this.config.id + " enabled");
};

SegmentController.prototype.setDisabled = function () {
    // send state control message over transport layer
    this.stateController.pushSegmentState(this.controlKey, 0);
    
    // updating UI
    setTrackElementColor(this.svgElem, window.settings.segment.inactiveColor);
    this.isSegmentEnabled = false;
    logEvent("Segment #" + this.config.id + " disabled");
};

SegmentController.prototype.setOccupied = function () {
    // TODO
}

SegmentController.prototype.setFree = function () {
    // TODO
}

SegmentController.prototype.DOMUpdatedCallback = function () {
    this.svgElem = $('#layout').find("#"+this.config.id);
    
    // add event handler for element
    this.svgElem.bind('click', {_this: this}, function (event) {
        if (event.data._this.isSegmentEnabled) {
            event.data._this.setDisabled();
        } else {
            event.data._this.setEnabled();
        }
    });
    
    // add control class to have pointer cursor over element
    this.svgElem.addClass("control");
};
