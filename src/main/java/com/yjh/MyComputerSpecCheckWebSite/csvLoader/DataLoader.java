package com.yjh.MyComputerSpecCheckWebSite.csvLoader;

import com.yjh.MyComputerSpecCheckWebSite.entity.GameMinimumRequirements;
import com.yjh.MyComputerSpecCheckWebSite.entity.computerParts.CPU;
import com.yjh.MyComputerSpecCheckWebSite.entity.computerParts.GPU;
import com.yjh.MyComputerSpecCheckWebSite.entity.computerParts.RAM;
import com.yjh.MyComputerSpecCheckWebSite.repository.GameMinimumRequirementsRepository;
import com.yjh.MyComputerSpecCheckWebSite.repository.computerPartsRepository.CPURepository;
import com.yjh.MyComputerSpecCheckWebSite.repository.computerPartsRepository.GPURepository;
import com.yjh.MyComputerSpecCheckWebSite.repository.computerPartsRepository.RAMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private CPURepository cpuRepository;
    @Autowired
    private GPURepository gpuRepository;
    @Autowired
    private RAMRepository ramRepository;
    @Autowired
    private GameMinimumRequirementsRepository gameMinimumRequirementsRepository;

    @Override
    public void run(String... args) throws Exception {
        loadCPUData();
        loadGPUData();
        loadRAMData();
        loadGameData();
    }

    private void loadCPUData() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ClassPathResource("/data/CPU.csv").getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            CPU cpu = new CPU();
            cpu.setName(data[0]);
            try {
                cpu.setTdp(Integer.parseInt(data[1]));
            } catch (NumberFormatException e) {
                cpu.setTdp(0);
            }
            cpu.setDate(data[2]);
            cpu.setCategory(data[3]);
            try {
                cpu.setSpeed(Integer.parseInt(data[4]));
            } catch (NumberFormatException e) {
                cpu.setSpeed(0);
            }
            try {
                cpu.setTurbo(Integer.parseInt(data[5]));
            } catch (NumberFormatException e) {
                cpu.setTurbo(0);
            }
            try {
                cpu.setCores(Integer.parseInt(data[6]));
            } catch (NumberFormatException e) {
                cpu.setCores(0);
            }
            cpuRepository.save(cpu);
        }
    }

    private void loadGPUData() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ClassPathResource("/data/GPU.csv").getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            GPU gpu = new GPU();
            gpu.setManufacturer(data[0]);
            gpu.setName(data[1]);
            try {
                gpu.setReleaseYear(Integer.parseInt(data[2]));
            } catch (NumberFormatException e) {
                gpu.setReleaseYear(0);
            }
            try {
                gpu.setMemSize(Integer.parseInt(data[3]));
            } catch (NumberFormatException e) {
                gpu.setMemSize(0);
            }
            try {
                gpu.setMemBusWidth(Integer.parseInt(data[4]));
            } catch (NumberFormatException e) {
                gpu.setMemBusWidth(0);
            }
            try {
                gpu.setGpuClock(Integer.parseInt(data[5]));
            } catch (NumberFormatException e) {
                gpu.setGpuClock(0);
            }
            try {
                gpu.setMemClock(Integer.parseInt(data[6]));
            } catch (NumberFormatException e) {
                gpu.setMemClock(0);
            }
            try {
                gpu.setUnifiedShader(Integer.parseInt(data[7]));
            } catch (NumberFormatException e) {
                gpu.setUnifiedShader(0);
            }
            try {
                gpu.setTmu(Integer.parseInt(data[8]));
            } catch (NumberFormatException e) {
                gpu.setTmu(0);
            }
            try {
                gpu.setRop(Integer.parseInt(data[9]));
            } catch (NumberFormatException e) {
                gpu.setRop(0);
            }
            gpu.setMemType(data[10]);
            gpuRepository.save(gpu);
        }
    }

    private void loadRAMData() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ClassPathResource("/data/RAM.csv").getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            RAM ram = new RAM();
            ram.setName(data[0]);
            try {
                ram.setSpeed(Double.parseDouble(data[2]));
            } catch (NumberFormatException e) {
                ram.setSpeed(null);
            }
            try {
                ram.setPricePerGB(Double.parseDouble(data[3]));
            } catch (NumberFormatException e) {
                ram.setPricePerGB(null);
            }
            try {
                ram.setFirstWordLatency(Double.parseDouble(data[4]));
            } catch (NumberFormatException e) {
                ram.setFirstWordLatency(null);
            }
            try {
                ram.setCasLatency(Double.parseDouble(data[5]));
            } catch (NumberFormatException e) {
                ram.setCasLatency(null);
            }
            ramRepository.save(ram);
        }
    }

    private void loadGameData() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ClassPathResource("/data/gameMinimumRequirements.csv").getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            GameMinimumRequirements game = new GameMinimumRequirements();
            game.setMemory(data[0]);
            game.setGPU(data[1]);
            game.setCPU(data[2]);
            game.setFileSize(data[3]);
            game.setSystem(data[4]);
            game.setName(data[5]);

            gameMinimumRequirementsRepository.save(game);
        }
    }
}