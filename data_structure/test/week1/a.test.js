const fs = require('fs-extra')
const {shell} = require('execa')
const {resolve} = require('path')
const java = require('../java-compile')
const srcDir = java.srcDir('week1/tree_height');
const testDir = java.srcDir('week1/tree_height/tests');
const srcFile = resolve(srcDir, 'tree_height.java')
describe('tree_height', () => {
    beforeAll(() => {
        java.compile(srcDir + '/tree_height.java');
    })

    java.getTests(srcFile).forEach(test => {
        it(`test case ${test.fileName}: should return ${test.answer}`, async () => {
            const a = await shell('java tree_height ', {
                cwd: java.root + '/gen',  
                input: test.input,
                encoding: 'utf8'
            })
            expect(a.stdout).toEqual(test.answer)

        }, 1500)
    })
})
