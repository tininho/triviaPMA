package com.adaptionsoft.games.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class Checker extends OutputStream {

	private Checksum checksum = new CRC32();

	@Override
	public void write(int b) throws IOException {
		checksum.update(b);
	}
	
	public long getChecksumValue(){
		return this.checksum.getValue();
	}
}
