package com.persistent.tourism.services;

import java.util.List;

import com.persistent.tourism.entities.Pack;

public interface PackageService {
List<Pack> getAllPackages();
void savePack(Pack pack);
Pack getPackageById(long id);
void deletePackageById(long id);
}
