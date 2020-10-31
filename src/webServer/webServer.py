#!/usr/bin/python
import subprocess

from flask import Flask, request

app = Flask("my_app1")


@app.route("/add")
def addition():
    if 'a' in request.args:
        a = int(request.args.get('a'))
    else:
        a = 0
    if 'b' in request.args:
        b = int(request.args.get('b'))
    else:
        b = 0
    return str(a) + ' + ' + str(b) + ' == ' + str(a + b) + '<br>' + "thanks" + '<br>'


@app.route("/sub")
def subtract():
    a = int(request.args.get('a'))
    b = int(request.args.get('b'))
    return str(a - b)


def string(param):
    pass


@app.route("/rail")
def rail_schedule():
    if 'outformat' in request.args:
        outformat = request.args.get('outformat')
    else:
        outformat = "html"

    if 'istaion' in request.args:
        istaion = request.args.get('iStaion')
    else:
        istaion = "Tel%20aviv"

    if 'fstaion' in request.args:
        fstaion = request.args.get('fStaion')
    else:
        istaion = "Tel%20aviv"

    if 'time' in request.args:
        time = string(request.args.get('time'))
    else:
        time = "12:00"

    return subprocess.check_output(["java", "-classpath", "../Rail_iL/bin", "CheckValidRides",
                                    outformat, istaion, fstaion, time])
