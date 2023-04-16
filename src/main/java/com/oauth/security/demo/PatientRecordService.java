package com.oauth.security.demo;

import com.oauth.security.config.JwtService;
import com.oauth.security.demo.dto.EcgDto;
import com.oauth.security.demo.dto.PresDetailDto;
import com.oauth.security.demo.dto.PrescriptionDto;
import com.oauth.security.token.Token;
import com.oauth.security.token.TokenRepository;
import com.oauth.security.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class PatientRecordService {

    private final RecordRepository recordRepository;
    private final JwtService tokenService;
    private final TokenRepository tokenRepository;


    public PatientRecord savePrescription(PrescriptionDto prescriptionDto){

        PatientRecord record = new PatientRecord();
        Token token = tokenRepository.findByToken(prescriptionDto.getAuth()).orElseThrow(()-> new RuntimeException("token not found"));

        record.setUsername(prescriptionDto.getNic());
        record .setType(prescriptionDto.getType());
        record .setDisease(prescriptionDto.getDisease());
        record .setDateTime(String.valueOf(LocalDateTime.now()));

        String presDetails ="";
        for(PresDetailDto dto : prescriptionDto.getList()){
            presDetails = presDetails + dto.getMedicine() + ":"+ dto.getUsage() + ":" + dto.getDose() + ",";
        }

        record.setPrescription(presDetails);

        return recordRepository.save(record);
    }

    public PatientRecord saveEcg(EcgDto ecgDto){

        PatientRecord record = new PatientRecord();
        Token token = tokenRepository.findByToken(ecgDto.getAuth()).orElseThrow(()-> new RuntimeException("token not found"));

        record.setUsername(token.getUser().getNic());
        record .setType(ecgDto.getType());
        record .setDisease(ecgDto.getDisease());
        record .setDateTime(String.valueOf(LocalDateTime.now()));

        return recordRepository.save(record);
    }

    public List<PrescriptionDto> getPrescriptions(){

        List<PatientRecord> ptList = recordRepository.findAllByType("PRES");
        System.out.println(ptList.toString());
        List<PrescriptionDto> returnList = new ArrayList<>();
        for (PatientRecord pt : ptList){
            PrescriptionDto prescriptionDto = new PrescriptionDto();
            prescriptionDto.setAuth(pt.getUsername());
            prescriptionDto.setDisease(pt.getDisease());
            prescriptionDto.setType(pt.getType());

            String[] presdetails = pt.getPrescription().split(",");
            List<PresDetailDto> detailList = new ArrayList<>();

            for(String str : presdetails){
                PresDetailDto presDetailDto = new PresDetailDto();
                String[] presDetail =  str.split(":");
                presDetailDto.setMedicine(presDetail[0]);
                presDetailDto.setUsage(presDetail[1]);
                presDetailDto.setDose(presDetail[2]);

                detailList.add(presDetailDto);
            }

            prescriptionDto.setList(detailList);
            returnList.add(prescriptionDto);
        }

        return returnList;
    }

    public List<EcgDto> getEcg(){

        List<PatientRecord> ptList = recordRepository.findAllByType("ECG");
        System.out.println(ptList.toString());
        List<EcgDto> returnList = new ArrayList<>();
        for (PatientRecord pt : ptList){
            EcgDto ecgDto = new EcgDto();
            ecgDto.setAuth(pt.getUsername());
            ecgDto.setDisease(pt.getDisease());
            ecgDto.setType(pt.getType());

            returnList.add(ecgDto);
        }

        return returnList;
    }

//    private List<PatientRecord> getRecords(){
//
//    }
}
